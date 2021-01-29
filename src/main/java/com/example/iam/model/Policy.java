package com.example.iam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IamPolicies")
public class Policy implements Serializable
{
	private static final long serialVersionUID = -7745939071878517482L; 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String policyId;
	
	@Column(name = "ResourceId")
	private String resourceId;
	
	@Column(name = "Scopes")
	private String scopes;
	
	@Column(name = "Relationships")
	private String relationships;
	
	@Column(name = "DegreeOfRelationship")
	private int degreeOfRelationship;

	protected Policy()
	{		
	}
	
	public Policy(String resourceId, String scopes, String relationships, int degreeOfRelationship)
	{
		this.resourceId = resourceId;
		this.scopes = scopes;
		this.relationships = relationships;
		this.degreeOfRelationship = degreeOfRelationship;
	}
	
	public String getPolicyId()
	{
		return policyId;
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

	public String getResourceId()
	{
		return resourceId;
	}

	public void setResourceId(String resourceId)
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