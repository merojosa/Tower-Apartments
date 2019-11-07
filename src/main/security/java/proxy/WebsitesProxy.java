package proxy;

import java.util.HashSet;

public class WebsitesProxy implements InternetService
{
	private HashSet<String> blockedWebsites;
	
	// Wrapper
	private InternetService proxyWrapper;
	
	
	public WebsitesProxy(InternetService proxy)
	{
		this.proxyWrapper = proxy;
		this.blockedWebsites = new HashSet<String>();
		loadBlockedWebsites();
	}
	
	
	public InternetService accessWebsite(String url) 
	{
		InternetService service = proxyWrapper.accessWebsite(url);
		if(service.isNull() == false && blockedWebsites.contains(url) == true)
		{
			service = new InternetNull();
		}
		
		return service;
	}
	
	// Este metodo variara cuando se configure realmente cuales seran los sitios bloqueados.
	private void loadBlockedWebsites()
	{
		blockedWebsites.add("xxx.com");
	}


	public boolean isNull() 
	{
		return false;
	}


}
