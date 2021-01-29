package com.example.iam.view;

public class ResourceUI
{ 
	private String resourceId;	
	private String iconUri;
	private String type;
	private String name;
	private String publicKey;
	private String ownerEID;
	private String resourceScopes;
	private String challenge;
	private String challengeResponse;
	private String entityId;

	public ResourceUI()
	{
	}
 
	public ResourceUI(String uri, String type, String name, String publicKey, String ownerEId, String resourceScopes)
	{
		this.iconUri = uri;
		this.type = type;
		this.name = name;
		this.publicKey = name;
		this.ownerEID = ownerEId;
		this.resourceScopes = resourceScopes;				
	}
	
	public String getResourceId()
	{
		return resourceId;
	}
	
	public String getIconUri() {
		return iconUri;
	}

	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceScopes() {
		return resourceScopes;
	}

	public void setResourceScopes(String resourceScopes) {
		this.resourceScopes = resourceScopes;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getOwnerEID() {
		return ownerEID;
	}

	public void setOwnerEID(String ownerEID) {
		this.ownerEID = ownerEID;
	}
	
	public String getChallenge()
	{
        return challenge;
    }
	
    public void setChallenge(String challenge)
    {
        this.challenge = challenge;
    }    

	public String getChallengeResponse()
	{
        return challengeResponse;
    }
	
    public void setChallengeResponse(String challengeResponse)
    {
        this.challengeResponse = challengeResponse;
    }
}