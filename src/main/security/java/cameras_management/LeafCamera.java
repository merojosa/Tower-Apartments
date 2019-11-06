package cameras_management;

import java.util.ArrayList;
import java.util.List;

import cameras_management.Camera.PropertiesCamera;

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
		this.camera.properties.setDirection(direction);
	}
	
	
	public void setState(Camera state) 
	{
		Object properties = state.getProperties();
		this.camera = state;
		this.camera.setProperties((PropertiesCamera) properties);
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
	
	
	public DirectionCamera getDirection()
	{
		return camera.getProperties().getDirection();
	}
}
