package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IamAlreadyExistsException extends IamException
{
	private static final long serialVersionUID = 2L;

	public IamAlreadyExistsException()
	{
        super();
    }

    public IamAlreadyExistsException(String message)
    {
        super(message);
    }

    public IamAlreadyExistsException(Throwable cause)
    {
        super(cause);
    }
    
    public IamAlreadyExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
