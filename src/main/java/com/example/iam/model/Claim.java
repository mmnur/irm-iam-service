package com.example.iam.model;

import java.io.Serializable;

public class Claim implements Serializable
{ 
	private static final long serialVersionUID = -914403979669919502L;
	
	private String client_id;
	private String redirect_uri;
	private String ticket;
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}