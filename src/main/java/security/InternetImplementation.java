package security;

public class InternetImplementation implements InternetService
{
	private InternetService proxy;
	
	public InternetImplementation()
	{		
		proxy = new WebsitesProxy(new AccessProxy());
	}

	public boolean accessWebsite(String url)
	{
		return proxy.accessWebsite(url);
	}

}
