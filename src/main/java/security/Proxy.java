package security;

public abstract class Proxy implements InternetService
{
	protected abstract boolean validateAccess(String url);	
}
