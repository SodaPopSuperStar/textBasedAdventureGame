package mockTextGameProject;

import java.io.IOException;

public class InvalidInputException extends IOException
{
	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = 7370505247203209426L;

	public InvalidInputException()
	{
		
	}
	
	public InvalidInputException(String msg)
	{
		super(msg);
	}
}
