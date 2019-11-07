package proxy;

public class InternetNull implements InternetService {

	public InternetService accessWebsite(String url) 
	{
		return this;
	}

	public boolean isNull() 
	{
		return true;
	}

}
