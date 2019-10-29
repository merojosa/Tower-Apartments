package security;

// Base decorator class
public class AccessProxy implements InternetService
{	
	private final int ACCESS_ALLOWED = 10;	
	
	private int accessCounter;

	
	public AccessProxy()
	{
		accessCounter = 0;
	}


	public InternetService accessWebsite(String url) 
	{
		InternetService service = new InternetImplementation();
		
		if(accessCounter < ACCESS_ALLOWED)
		{
			++accessCounter;
		}
		else
		{
			service = new InternetNull();
		}

		return service;
	}


	public boolean isNull() 
	{
		return false;
	}
}
