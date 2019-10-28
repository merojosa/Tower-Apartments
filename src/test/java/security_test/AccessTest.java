package security_test;

import org.junit.Assert;
import org.junit.Test;

import security.InternetImplementation;
import security.InternetService;

public class AccessTest 
{
	@Test
	public void testValidUrl()
	{
		InternetService service = new InternetImplementation();
		Assert.assertTrue(service.accessWebsite("facebook.com"));
	}
	
	@Test
	public void testBlockedUrl()
	{
		InternetService service = new InternetImplementation();
		Assert.assertFalse(service.accessWebsite("xxx.com"));
	}
	
	@Test
	public void testCountAccesses()
	{
		InternetService service = new InternetImplementation();
		service.accessWebsite("facebook.com");
		service.accessWebsite("hotmail.com");
		service.accessWebsite("twitter.com");
		service.accessWebsite("hotmail.com");
		service.accessWebsite("gmail.com");
		service.accessWebsite("facebook.com");
		service.accessWebsite("instagram.com");
		service.accessWebsite("google.com");
		service.accessWebsite("drive.com");
		service.accessWebsite("github.com");
		Assert.assertFalse(service.accessWebsite("facebook.com"));
	}
}
