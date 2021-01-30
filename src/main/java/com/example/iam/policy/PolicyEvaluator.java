package com.example.iam.policy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.iam.error.IamOAuth2Exception;
import com.example.iam.model.Policy;
import com.example.iam.model.Resource;
import com.example.iam.repository.PolicyRepository;

public class PolicyEvaluator
{	
	@Autowired
	PolicyRepository policyRepository;
	
	public boolean isAuthorized(Resource resource, String actorEntityId)
			throws IamOAuth2Exception
	{
		/*
		 * RestTemplate restTemplate = new RestTemplate(); String irmResourceUrl =
		 * irmSerserUrl + relationshipEndpoint + "/find"; ResponseEntity<String>
		 * response = restTemplate.getForEntity(irmResourceUrl + "/1", String.class);
		 */		
		return false;
	}

	public List<Policy> getPolicyByResourceId(String resourceId)
	{
		List<Policy> policies = policyRepository.findByResourceId(resourceId);
		return policies;
	}	
}
