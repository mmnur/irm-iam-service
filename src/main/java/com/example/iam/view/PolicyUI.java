package com.example.iam.view;

import java.io.Serializable;

public class PolicyUI implements Serializable
{
	private static final long serialVersionUID = -7745939071878517482L; 
	
	private int resourceId;
	private String scopes;
	private String relationships;
	private int degreeOfRelationship;

	public PolicyUI()
	{		
	}
	
	public PolicyUI(int resourceId, String scopes, String relationships, int degreeOfRelationship)
	{
		this.resourceId = resourceId;
		this.scopes = scopes;
		this.relationships = relationships;
		this.degreeOfRelationship = degreeOfRelationship;
	}
	
	public String getScopes()
	{
		return scopes;
	}

	public void setScopes(String scopes)
	{
		this.scopes = scopes;
	}

	public String getRelationships()
	{
		return relationships;
	}

	public void setRelationships(String relationships)
	{
		this.relationships = relationships;
	}

	public int getResourceId()
	{
		return resourceId;
	}

	public void setResourceId(int resourceId)
	{
		this.resourceId = resourceId;
	}

	public int getDegreeOfRelationship()
	{
		return degreeOfRelationship;
	}

	public void setDegreeOfRelationship(int degreeOfRelationship)
	{
		this.degreeOfRelationship = degreeOfRelationship;
	}
}