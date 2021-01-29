package com.example.iam.view;

public class DeviceUI
{ 
    private String entityId;
	private String displayName;
	private String ownerEID;
	private String publicKey;
	private String challenge;
	private String challengeResponse;

	public DeviceUI()
	{
	}
 
	public DeviceUI(String displayName, String ownerEID, String publicKey, String challenge, Boolean registerationCompleted)
	{
		this.displayName = displayName;
		this.ownerEID = ownerEID;
		this.publicKey = publicKey;
		this.challenge = challenge;
	}
 
	public String getEntityId()
	{
		return entityId;
	}
	
	public void setEntityId(String entityId)
	{
		this.entityId = entityId;
	}
	
	public String getDisplayName()
	{
        return displayName;
    }
	
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
    
	public String getOwnerEID()
	{
        return ownerEID;
    }
	
    public void setOwnerEID(String ownerEID)
    {
        this.ownerEID = ownerEID;
    }
    
	public String getPublicKey()
	{
        return publicKey;
    }
	
    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
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