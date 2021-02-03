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
		Boolean isAuthorized = false;
		Resource resource = resourceRepository.findByEntityId(targetEntityId).get(0);
		List<Policy> policies = policyRepository.findByResourceId(resource.getResourceId());
		for (Policy policy:policies) {
			List<List<RelationshipUI>> allRelationships = new IrmClient().findRelationships(targetEntityId, actorEntityId, policy.getDegreeOfRelationship());
			if (allRelationships != null) {
				for(List<RelationshipUI> relationships:allRelationships) {
					for(RelationshipUI relationship:relationships) {
						//if (relationship.getEntitySrc())
					}
				}
			}
		}
		
		Map<String, String> retValue = new HashMap<String, String>();
		retValue.put("targetEntityId", targetEntityId);
		retValue.put("actorEntityId", actorEntityId);
		retValue.put("scopes", scopes);
		if (isAuthorized) {
			retValue.put("Authorization", "Allow");
		} else {
			retValue.put("Authorization", "Deny");
		}

		return retValue;
	}
}
