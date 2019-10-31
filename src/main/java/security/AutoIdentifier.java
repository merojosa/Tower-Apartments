package security;

public interface AutoIdentifier 
{
	public boolean canIdentify(Camera camera, String ID);
	public String identify(Camera camera, String ID);
}
