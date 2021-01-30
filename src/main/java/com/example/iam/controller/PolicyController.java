package com.example.iam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.iam.repository.PolicyRepository;
import com.example.iam.view.PolicyUI;
import com.example.iam.model.Policy;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policies")
public class PolicyController {
	@Autowired
	PolicyRepository policyRepository;

	@PostMapping(path = "/initreg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> registerInitialize(@RequestBody PolicyUI policyUI)
	{
		Policy policy = policyRepository.save(
				new Policy(policyUI.getResourceId(), policyUI.getScopes(), policyUI.getRelationships(), policyUI.getDegreeOfRelationship()));

		Map<String, String> retValue = new HashMap<String, String>();
		retValue.put("policyId", policy.getPolicyId());

		return retValue;
	}
	
	@GetMapping(path = "/findall")
	public List<Policy> findAll() {
		List<Policy> policies = policyRepository.findAll();
		return policies;
	}
}