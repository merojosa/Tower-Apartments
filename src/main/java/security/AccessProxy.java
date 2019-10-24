package security;

// Base decorator class
public class AccessProxy implements InternetService, Proxy
{	
	private final int ACCESS_ALLOWED = 10;	
	private final InternetService service;
	
	private int accessCounter;

	
	public AccessProxy(InternetService service)
	{
		this.service = service;
	}


	public boolean validateAccess(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean accessWebsite(String url) 
	{
		if(accessCounter <= ACCESS_ALLOWED)
		{
			++accessCounter;
			return service.accessWebsite(url);
		}

		return false;
	}
}
