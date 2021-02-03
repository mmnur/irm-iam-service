package com.example.iam.utils;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.iam.error.IamIrmException;
import com.example.iam.view.DeviceUI;
import com.example.iam.view.RelationshipUI;
import com.example.iam.view.ResourceUI;

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
			throws IamIrmException
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    irmServiceUrl = "http://localhost:9090" + "/relationships/find";
	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(irmServiceUrl);
	    builder.queryParam("entityIdSrc", targetEntityId);
	    builder.queryParam("entityIdTgt", actorEntityId);
	    builder.queryParam("maxDegreeOfRelationship", String.valueOf(degreeOfRelationship));
	     
	    RestTemplate restTemplate = new RestTemplate();	     
	    ResponseEntity<List<List<RelationshipUI>>> response = null;
	    try {
	    	ParameterizedTypeReference<List<List<RelationshipUI>>> responseType = new ParameterizedTypeReference<List<List<RelationshipUI>>>() {};
	    	response = restTemplate.exchange(
	    			builder.toUriString(),
					HttpMethod.GET,
					new HttpEntity(headers),	    			
					responseType);
	    } catch (HttpClientErrorException e) {	    	
	    	e.printStackTrace();
	    	return null;
	    }	     
	    return response.getBody();		
	}
	
	
	public List<List<RelationshipUI>> findRelationshipsByType(String actorEntityId, String orgType, int degreeOfRelationship)
			throws IamIrmException
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    irmServiceUrl = "http://localhost:9090" + "/relationships/findbytype";
	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(irmServiceUrl);
	    builder.queryParam("actorEntityIdSrc", actorEntityId);
	    builder.queryParam("orgType", orgType);
	    builder.queryParam("maxDegreeOfRelationship", String.valueOf(degreeOfRelationship));
	     
	    RestTemplate restTemplate = new RestTemplate();	     
	    ResponseEntity<List<List<RelationshipUI>>> response = null;
	    
	    try {
	    	
	    	ParameterizedTypeReference<List<List<RelationshipUI>>> responseType = new ParameterizedTypeReference<List<List<RelationshipUI>>>() {};
	    	response = restTemplate.exchange(
	    			builder.toUriString(), 
					HttpMethod.GET,
					new HttpEntity(headers),
					responseType);
	    } catch (HttpClientErrorException e) {	    	
	    	e.printStackTrace();
	    	return null;
	    }	     
	    return response.getBody();		
	}
}
