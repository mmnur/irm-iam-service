package com.example.iam.policy;

import com.example.iam.error.IamOAuth2Exception;
import com.example.iam.model.Resource;

public class PolicyEvaluator {


	
	public boolean isAuthorized(String userName, Resource resource)
			throws IamOAuth2Exception
	{
		/*
		 * RestTemplate restTemplate = new RestTemplate(); String irmResourceUrl =
		 * irmSerserUrl + relationshipEndpoint + "/find"; ResponseEntity<String>
		 * response = restTemplate.getForEntity(irmResourceUrl + "/1", String.class);
		 */		
		return false;
	}

}
