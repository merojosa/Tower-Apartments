package security_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import security.AccessProxy;
import security.InternetImplementation;
import security.InternetService;
import security.WebsitesProxy;

public class ProxyTest 
{
	private InternetService proxy;
	
	@Before
	public void init()
	{
		proxy = new WebsitesProxy(new AccessProxy());
	}
	
	@Test
	public void testValidUrl()
	{
		InternetService service = proxy.accessWebsite("facebook.com");
		Assert.assertFalse(service.isNull());
	}
	
	@Test
	public void testBlockedUrl()
	{
		InternetService service = proxy.accessWebsite("xxx.com");
		Assert.assertTrue(service.isNull());
	}
	
	@Test
	public void testCountAccesses()
	{
		proxy.accessWebsite("facebook.com");
		proxy.accessWebsite("hotmail.com");
		proxy.accessWebsite("twitter.com");
		proxy.accessWebsite("hotmail.com");
		proxy.accessWebsite("gmail.com");
		proxy.accessWebsite("facebook.com");
		proxy.accessWebsite("instagram.com");
		proxy.accessWebsite("google.com");
		proxy.accessWebsite("drive.com");
		proxy.accessWebsite("github.com");
		InternetService service = proxy.accessWebsite("facebook.com");
		
		Assert.assertTrue(service.isNull());
	}
}
