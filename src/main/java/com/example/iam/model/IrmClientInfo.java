package com.example.iam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IamClientInfo")
public class IrmClientInfo implements Serializable
{
	private static final long serialVersionUID = -1736520105208077847L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String id;	

	@Column(name = "IrmServiceUri")
	private String irmServiceUri;
	
	@Column(name = "ClientId")
	private String clientId;
	
	@Column(name = "ClientSercret")
	private String clientSecret;

	public String getId() {
		return id;
	}

	public String getIrmServiceUri() {
		return irmServiceUri;
	}

	public void setIrmServiceUri(String irmServiceUri) {
		this.irmServiceUri = irmServiceUri;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}
