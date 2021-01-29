package com.example.iam.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IamResources")
public class Resource implements Serializable
{ 
	private static final long serialVersionUID = -7354009071375201447L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String resourceId;	
    
	@Column(name = "IconUri")
	private String iconUri;
 
	@Column(name = "Type")
	private String type;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "ResourceScopes")
	private String resourceScopes;

	@Column(name = "EntityId")
	private String entityId;

	protected Resource()
	{
	}
 
	public Resource(String uri, String type, String name, String resourceScopes)
	{
		this.iconUri = uri;
		this.type = type;
		this.name = name;
		this.resourceScopes = resourceScopes;				
	}
	
	public String getResourceId()
	{
		return resourceId;
	}
	
	public String getIconUri()
	{
		return iconUri;
	}

	public void setIconUri(String iconUri)
	{
		this.iconUri = iconUri;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getResourceScopes()
	{
		return resourceScopes;
	}

	public void setResourceScopes(String resourceScopes)
	{
		this.resourceScopes = resourceScopes;
	}

	public String getEntityId()
	{
		return entityId;
	}

	public void setEntityId(String entityId)
	{
		this.entityId = entityId;
	}
}