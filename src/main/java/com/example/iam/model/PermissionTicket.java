package com.example.iam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IamPermissionTickets")
public class PermissionTicket
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String id;
	
	private String claims;
    private int resourceId;
    private String resourceScopes;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getClaims() {
		return claims;
	}
	public void setClaims(String claims) {
		this.claims = claims;
	}
	public int getResource_id() {
		return resourceId;
	}
	public void setResource_id(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResource_scopes() {
		return resourceScopes;
	}
	public void setResource_scopes(String resourceScopes) {
		this.resourceScopes = resourceScopes;
	}

 
}
