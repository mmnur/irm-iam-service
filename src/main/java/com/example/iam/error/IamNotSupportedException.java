package com.example.iam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IamNotSupportedException extends IamException
{
	private static final long serialVersionUID = 2L;

	public IamNotSupportedException()
	{
        super();
    }

    public IamNotSupportedException(String message)
    {
        super(message);
    }

    public IamNotSupportedException(Throwable cause)
    {
        super(cause);
    }
    
    public IamNotSupportedException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
