package security;

import java.util.List;

public class CompositeCamera implements Camera
{
	private List<Camera> cameras;
	
	public CompositeCamera(List<Camera> cameras)
	{
		this.cameras = cameras;
	}

	public void setState(StateCamera state) 
	{
		for(Camera camera : cameras)
		{
			camera.setState(state);
		}
	}

	
	public void setDirection(DirectionCamera direction) 
	{
		for(Camera camera : cameras)
		{
			camera.setDirection(direction);
		}
	}
	
	public List<Camera> getCameras()
	{
		return cameras;
	}

}
