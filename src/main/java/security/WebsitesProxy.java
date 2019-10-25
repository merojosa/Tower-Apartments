package security;

import java.util.HashSet;
import java.util.List;

public class WebsitesProxy extends Proxy
{
	private HashSet<String> forbiddenWebsites;
	
	// Wrapper
	private Proxy proxy;
	
	
	public WebsitesProxy(Proxy proxy)
	{
		this.proxy = proxy;
	}
	
	
	@Override
	protected boolean validateAccess(String url) 
	{
		if(forbiddenWebsites.contains(url) == true)
		{
			return false;
		}
		else
		{
			return ((AccessProxy) proxy).accessWebsite(url);
		}
	}
	
	public boolean accessWebsite(String url) 
	{
		return validateAccess(url);
	}
	

	public void setForbiddenWebsites(HashSet<String> forbiddenWebsites) 
	{
		this.forbiddenWebsites = forbiddenWebsites;
	}

}
