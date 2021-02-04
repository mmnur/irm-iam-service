package com.example.iam.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.iam.error.IamIrmException;
import com.example.iam.view.DeviceUI;
import com.example.iam.view.RelationshipUI;
import com.example.iam.view.ResourceUI;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ComponentScan(basePackages = "com.example")
public class IrmClient {
	
	@Value( "${irm.server.url}" )
	private String irmServiceUrl;	

	public String regInit(ResourceUI resourceUI)
			throws IamIrmException
	{
		 HttpHeaders headers = new HttpHeaders();
	     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
	     DeviceUI device = new DeviceUI();
	     device.setDisplayName(resourceUI.getName());
	     device.setOwnerEID(resourceUI.getOwnerEID());
	     device.setPublicKey(resourceUI.getPublicKey());	     
	     HttpEntity<DeviceUI> entity = new HttpEntity<DeviceUI>(device, headers);
	     RestTemplate restTemplate = new RestTemplate();
	     
	     irmServiceUrl = "http://localhost:9090";
	     Map<String, String> response = null;
	     try {
	    	 response = restTemplate.exchange(irmServiceUrl + "/devices/initreg", HttpMethod.POST, entity, Map.class).getBody();
	    } catch (HttpClientErrorException e) {
	    	throw new IamIrmException(String.valueOf(e.getRawStatusCode()), e);
	    }
	     
    	return response.get("challenge");
	}
	
	public String regFinish(ResourceUI resourceUI)
			throws IamIrmException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 
		DeviceUI device = new DeviceUI();
		device.setChallenge(resourceUI.getChallenge());
		device.setChallengeResponse(resourceUI.getChallengeResponse());
		HttpEntity<DeviceUI> entity = new HttpEntity<DeviceUI>(device, headers);
		 
		RestTemplate restTemplate = new RestTemplate();		 
		irmServiceUrl = "http://localhost:9090";
		Map<String, String> response = null;
		try {
			response = restTemplate.exchange(irmServiceUrl + "/devices/finishreg", HttpMethod.POST, entity, Map.class).getBody();
		} catch (HttpClientErrorException e) {
			throw new IamIrmException(String.valueOf(e.getRawStatusCode()), e);
		}
		 
		return response.get("entityId");		
	}
	
	public List<List<RelationshipUI>> findRelationships(String targetEntityId, String actorEntityId, int degreeOfRelationship)
			throws JsonParseException, JsonMappingException, IOException
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));    
	    
	    FindRelationshipRequest findRelationshipRequest = new FindRelationshipRequest();
	    findRelationshipRequest.setEntityIdSrc(targetEntityId);
	    findRelationshipRequest.setEntityIdTgt(actorEntityId);
	    findRelationshipRequest.setMaxDegreeOfRelationship(degreeOfRelationship);
	    HttpEntity<FindRelationshipRequest> entity = new HttpEntity<FindRelationshipRequest>(findRelationshipRequest, headers);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    irmServiceUrl = "http://localhost:9090";
		ParameterizedTypeReference<List<List<RelationshipUI>>> parameterizedTypeReference = new ParameterizedTypeReference<List<List<RelationshipUI>>>(){};		    
		List<List<RelationshipUI>> response = (List<List<RelationshipUI>>) restTemplate.exchange(irmServiceUrl + "/relationships/find", HttpMethod.POST, entity, parameterizedTypeReference).getBody();
		
		return response;	
	}
}
