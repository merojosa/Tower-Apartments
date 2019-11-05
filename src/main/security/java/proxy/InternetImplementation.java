package proxy;

public class InternetImplementation implements InternetService
{

	public InternetService accessWebsite(String url)
	{
		return this;
	}

	public boolean isNull() 
	{
		return false;
	}

}
