package com.example.iam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.iam.repository.PolicyRepository;
import com.example.iam.repository.ResourceRepository;
import com.example.iam.utils.IrmClient;
import com.example.iam.view.RelationshipUI;
import com.example.iam.error.IamIrmException;
import com.example.iam.error.IamNotFoundException;
import com.example.iam.model.Policy;
import com.example.iam.model.Resource;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController
{
	@Autowired
	PolicyRepository policyRepository;

	@Autowired
	ResourceRepository resourceRepository;
	
	@GetMapping(
			path = "/checkaccess",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> checkAccess(@RequestParam String targetEntityId, @RequestParam String actorEntityId, @RequestParam String scopes)
			throws IamIrmException, IamNotFoundException
	{
		List<Resource> resources = resourceRepository.findByEntityId(targetEntityId);
		if (resources.size() < 1) {
			throw new IamNotFoundException("Not found: " + targetEntityId);
		}
		Resource resource = resources.get(0);
		
		List<Policy> policies = policyRepository.findByResourceId(resource.getResourceId());
		if (policies.size() < 1) {
			throw new IamNotFoundException("No policy found for: " + targetEntityId);
		}

		HashMap<String, String> scopesRequested = new HashMap<String, String>();
		for(String scope: scopes.split(",")) {
			scopesRequested.put(scope.toLowerCase(), "deny");
		}
		
		for (Policy policy:policies) {
			try {
				List<List<RelationshipUI>> allRelationships = new IrmClient().findRelationships(targetEntityId, actorEntityId, policy.getDegreeOfRelationship());
				if (allRelationships != null) {
					for(List<RelationshipUI> relationships:allRelationships) {
						for(RelationshipUI relationship:relationships) {
							if (relationship.getEntitySrc().compareToIgnoreCase(targetEntityId) == 0 &&
								relationship.getRelationTypeS2T().compareToIgnoreCase("OwnedBy") == 0) {
								continue;
							} else {
								String[] policyRelationshipsCriteria = policy.getRelationships().split(",");
								if (relationship.getEntityTgt().compareToIgnoreCase(actorEntityId) == 0) {
									for (String policyRelationship:policyRelationshipsCriteria) {
										if (policyRelationship.compareToIgnoreCase(relationship.getRelationTypeT2S()) == 0) {
											for (String policyScope:policy.getScopes().split(",")) {
												if (scopesRequested.containsKey(policyScope.toLowerCase())) {
													scopesRequested.put(policyScope.toLowerCase(), "approve");
												}
											}
										}
									}
								}								
							}
						}
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		scopesRequested.put("targetEntityId", targetEntityId);
		scopesRequested.put("actorEntityId", actorEntityId);
		
		return scopesRequested;
	}
}
