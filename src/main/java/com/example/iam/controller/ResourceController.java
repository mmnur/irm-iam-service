package com.example.iam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.iam.repository.ResoureRepository;
import com.example.iam.view.ResourceUI;
import com.example.iam.error.IamNotFoundException;
import com.example.iam.irm.IrmClient;
import com.example.iam.model.Resource;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resourceSet")
public class ResourceController {
	@Autowired
	ResoureRepository resoureRepository;

	@PostMapping(path = "/initreg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> registerInitialize(@RequestBody ResourceUI resourceUI)
	{
		Resource resource = resoureRepository.save(
				new Resource(resourceUI.getIconUri(), resourceUI.getType(), resourceUI.getName(), resourceUI.getResourceScopes()));

		IrmClient irmClient = new IrmClient();
		String challenge = irmClient.regInit(resourceUI);

		Map<String, String> retValue = new HashMap<String, String>();
		retValue.put("resourceId", resource.getResourceId());
		retValue.put("challenge", challenge);

		return retValue;
	}
	
	@PostMapping(path = "/finishreg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> registerFinish(@RequestBody ResourceUI resourceUI)
			throws IamNotFoundException
	{
		if (resoureRepository.findByResourceId(resourceUI.getResourceId()).size() <= 0) {
			throw new IamNotFoundException(resourceUI.getResourceId() + " not found!");
		}
	
		IrmClient irmClient = new IrmClient();
		String entityId = irmClient.regFinish(resourceUI);

		Map<String, String> retValue = new HashMap<String, String>();
		retValue.put("resourceId", resourceUI.getResourceId());
		retValue.put("entityId", entityId);

		return retValue;
	}

	@GetMapping(path = "/{resourceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource find(@RequestBody String resourceId) throws IamNotFoundException {
		List<Resource> resources = resoureRepository.findByResourceId(resourceId);

		if (resources.isEmpty()) {
			throw new IamNotFoundException("Resource not found!");
		}

		return resources.get(0);
	}

	@GetMapping(path = "/findall")
	public List<Resource> findAll() {
		List<Resource> resources = resoureRepository.findAll();
		return resources;
	}
}