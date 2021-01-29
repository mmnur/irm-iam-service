package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IamNotFoundException extends IamException
{
	private static final long serialVersionUID = 2L;

	public IamNotFoundException()
	{
        super();
    }

    public IamNotFoundException(String message)
    {
        super(message);
    }

    public IamNotFoundException(Throwable cause)
    {
        super(cause);
    }
    
    public IamNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
