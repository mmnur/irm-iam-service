package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IamOAuth2Exception extends IamException
{
	private static final long serialVersionUID = 2L;

	public IamOAuth2Exception()
	{
        super();
    }

    public IamOAuth2Exception(String message)
    {
        super(message);
    }

    public IamOAuth2Exception(Throwable cause)
    {
        super(cause);
    }
    
    public IamOAuth2Exception(String message, Throwable cause)
    {
        super(message, cause);
    }
}
