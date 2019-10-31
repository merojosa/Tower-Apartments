package security;

import java.util.ArrayList;
import java.util.List;

public class LeafCamera implements ComponentCamera 
{
	private Camera camera;
	
	public LeafCamera(Camera camera)
	{
		this.camera = camera;
	}
	
	
	public LeafCamera(Camera camera, DirectionCamera direction)
	{
		this.camera = camera;
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
		camera.setDirection(direction);
	}


	public List<ComponentCamera> getSetCamera() 
	{
		List<ComponentCamera> list = new ArrayList<ComponentCamera>();
		list.add(this);
		return list;
	}
	
	
	public PropertiesCamera getProperties()
	{
		return camera.getProperties();
	}
}
