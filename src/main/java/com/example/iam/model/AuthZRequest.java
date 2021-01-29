package com.example.iam.model;

import java.io.Serializable;

public class AuthZRequest implements Serializable
{
	private static final long serialVersionUID = -5507979975156605472L;
	
	private String ticket;
    private String rpt;
    private String grantType;
    private String claimToken;
    private String claimTokenFormat;
    
    public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getRpt() {
		return rpt;
	}
	public void setRpt(String rpt) {
		this.rpt = rpt;
	}
	public String getGrant_type() {
		return grantType;
	}
	public void setGrant_type(String grant_type) {
		this.grantType = grant_type;
	}
	public String getClaim_token() {
		return claimToken;
	}
	public void setClaim_token(String claim_token) {
		this.claimToken = claim_token;
	}
	public String getClaim_token_format() {
		return claimTokenFormat;
	}
	public void setClaim_token_format(String claim_token_format) {
		this.claimTokenFormat = claim_token_format;
	}
}
