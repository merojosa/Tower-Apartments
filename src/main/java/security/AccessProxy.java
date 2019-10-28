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


	public boolean accessWebsite(String url) 
	{
		if(accessCounter < ACCESS_ALLOWED)
		{
			++accessCounter;
			return true;
		}

		return false;
	}
}
