package security;

public class LeafCamera implements ComponentCamera 
{
	private Camera camera;
	
	public LeafCamera(Camera state)
	{
		this.camera = state;
	}
	
	
	public LeafCamera(Camera state, DirectionCamera direction)
	{
		this.camera = state;
		this.camera.setDirection(direction);
	}
	
	
	public void setState(Camera state) 
	{
		// If it changes the state of the camera, doesn't mean it changes the properties.
		PropertiesCamera properties = camera.getProperties();
		this.camera = state;
		camera.setProperties(properties);
	}

	
	public void setDirection(DirectionCamera direction) 
	{
		this.camera.setDirection(direction);
	}
	
	
	public Camera getState()
	{
		return camera;
	}
}
