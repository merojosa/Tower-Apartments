package security;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecurityTest 
{
	
	private InternetService service;
	private Proxy accessProxy;
	private Proxy websitesProxy;

	
	@Before
	public void initObjects()
	{
		service = new InternetImplementation(); 
		accessProxy = new AccessProxy(service);
		
		websitesProxy = new WebsitesProxy(new AccessProxy(service));
		HashSet<String> forbiddenWebsites = new HashSet<String>();
		forbiddenWebsites.add("xxx.com");
		((WebsitesProxy) websitesProxy).setForbiddenWebsites(forbiddenWebsites);
	}
	
	
	@Test
	public void allowAccessProxyTest() 
	{
		Assert.assertTrue(accessProxy.accessWebsite("facebook.com"));
	}
	

	@Test
	public void allowWebsitesProxyTest() 
	{		
		Assert.assertTrue(websitesProxy.accessWebsite("facebook.com"));
	}
	
	
	@Test
	public void denyAccessProxyTest()
	{
		Assert.assertTrue(accessProxy.accessWebsite("facebook.com"));
		Assert.assertTrue(accessProxy.accessWebsite("hotmail.com"));
		Assert.assertTrue(accessProxy.accessWebsite("twitter.com"));
		Assert.assertTrue(accessProxy.accessWebsite("facebook.com"));
		Assert.assertTrue(accessProxy.accessWebsite("facebook.com"));
		Assert.assertTrue(accessProxy.accessWebsite("gmail.com"));
		Assert.assertTrue(accessProxy.accessWebsite("google.com"));
		Assert.assertTrue(accessProxy.accessWebsite("instagram.com"));
		Assert.assertTrue(accessProxy.accessWebsite("teletica.com"));
		Assert.assertTrue(accessProxy.accessWebsite("repretel.com"));
		// Denied.
		Assert.assertFalse(accessProxy.accessWebsite("facebook.com"));
	}
	
	
	@Test
	public void denyWebsitesProxyTest()
	{
		Assert.assertFalse(websitesProxy.accessWebsite("xxx.com"));
	}
}
