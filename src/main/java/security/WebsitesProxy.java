package security;

import java.util.HashSet;
import java.util.List;

public class WebsitesProxy implements Proxy
{
	private HashSet<String> forbiddenWebsites;
	
	// Wrapper
	private Proxy proxy;
	
	
	public WebsitesProxy(Proxy proxy)
	{
		this.proxy = proxy;
	}
	

	public boolean validateAccess(String url) 
	{
		if(forbiddenWebsites.contains(url) == true)
		{
			return false;
		}
		else
		{
			return proxy.validateAccess(url);
		}
	}
	

	public void setForbiddenWebsites(HashSet<String> forbiddenWebsites) 
	{
		this.forbiddenWebsites = forbiddenWebsites;
	}

}
