package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IamException extends Exception
{
	private static final long serialVersionUID = 1L;

	public IamException()
	{
        super();
    }

    public IamException(String message)
    {
        super(message);
    }

    public IamException(Throwable cause)
    {
        super(cause);
    }
    
    public IamException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
