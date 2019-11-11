package cameras_management;

public interface AutoIdentifier 
{
	public boolean canIdentify(Camera camera, String ID);
	public String identify(Camera camera, String ID);
}
