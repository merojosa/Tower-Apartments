package cameras_management;

public class CameraIdentifier implements AutoIdentifier
{
	
	public boolean canIdentify(Camera camera, String ID)
	{
		if (camera.properties.containID(ID) == true)
			return true;
		else
			return false;
	}
	
	public String identify(Camera camera, String ID)
	{
		return "La camara en " + camera.properties.getLocation() + " identifico al ID: " + ID; 
	}
}