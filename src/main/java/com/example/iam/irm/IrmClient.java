package com.example.iam.irm;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.iam.model.Resource;
import com.example.iam.view.DeviceUI;
import com.example.iam.view.ResourceUI;

public class IrmClient {
	
	@Value( "${irm.server.url}" )
	private String irmServiceUrl;	

	public String regInit(ResourceUI resourceUI)
	{
		 HttpHeaders headers = new HttpHeaders();
	     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
	     DeviceUI device = new DeviceUI();
	     device.setDisplayName(resourceUI.getName());
	     device.setOwnerEID(resourceUI.getOwnerEID());
	     device.setPublicKey(resourceUI.getPublicKey());	     
	     HttpEntity<DeviceUI> entity = new HttpEntity<DeviceUI>(device);
	     
	     RestTemplate restTemplate = new RestTemplate();
	     
	     irmServiceUrl = "http://localhost:9090";
	     Map<String, String> response = restTemplate.exchange(irmServiceUrl + "/devices/initreg", HttpMethod.POST, entity, Map.class).getBody();
	     
	     return response.get("challenge");		
	}
	
	public String regFinish(ResourceUI resourceUI)
	{
		 HttpHeaders headers = new HttpHeaders();
	     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
	     DeviceUI device = new DeviceUI();
	     device.setChallenge(resourceUI.getChallenge());
	     device.setChallengeResponse(resourceUI.getChallengeResponse());
	     HttpEntity<DeviceUI> entity = new HttpEntity<DeviceUI>(device);
	     
	     RestTemplate restTemplate = new RestTemplate();
	     
	     irmServiceUrl = "http://localhost:9090";
	     Map<String, String> response = restTemplate.exchange(irmServiceUrl + "/devices/finishreg", HttpMethod.POST, entity, Map.class).getBody();
	     
	     return response.get("entityId");		
	}
}
