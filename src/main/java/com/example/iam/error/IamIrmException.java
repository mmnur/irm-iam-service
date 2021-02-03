package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IamIrmException extends IamException
{
	private static final long serialVersionUID = 1L;

	public IamIrmException()
	{
        super();
    }

    public IamIrmException(String message)
    {
        super(message);
    }

    public IamIrmException(Throwable cause)
    {
        super(cause);
    }
    
    public IamIrmException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
