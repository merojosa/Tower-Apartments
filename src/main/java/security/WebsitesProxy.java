package security;

import java.util.HashSet;

public class WebsitesProxy implements InternetService
{
	private HashSet<String> blockedWebsites;
	
	// Wrapper
	private InternetService proxy;
	
	
	public WebsitesProxy(InternetService proxy)
	{
		this.proxy = proxy;
		this.blockedWebsites = new HashSet<String>();
		loadBlockedWebsites();
	}
	
	
	public boolean accessWebsite(String url) 
	{
		if(proxy.accessWebsite(url) == false)
		{
			return false;
		}
		
		// False if the url exists in forbiddenWebsites.
		return !blockedWebsites.contains(url);
	}
	
	// Este metodo variara cuando se configure realmente cuales seran los sitios bloqueados.
	private void loadBlockedWebsites()
	{
		blockedWebsites.add("xxx.com");
	}


}
