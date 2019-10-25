package security;

// Base decorator class
public class AccessProxy extends Proxy
{	
	private final int ACCESS_ALLOWED = 10;	
	private final InternetService service;
	
	private int accessCounter;

	
	public AccessProxy(InternetService service)
	{
		this.service = service;
		accessCounter = 0;
	}


	@Override
	protected boolean validateAccess(String url) 
	{
		if(accessCounter < ACCESS_ALLOWED)
		{
			++accessCounter;
			return true;
		}

		return false;
	}


	public boolean accessWebsite(String url) 
	{
		if(validateAccess(url) == true)
		{
			return service.accessWebsite(url);
		}
		
		return false;
	}
}
