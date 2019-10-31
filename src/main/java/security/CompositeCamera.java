package security;

import java.util.ArrayList;
import java.util.List;

public class CompositeCamera implements ComponentCamera
{
	private List<ComponentCamera> cameras;
	
	private CompositeCamera()
	{
		cameras = new ArrayList<ComponentCamera>();
	}

	
	public void setState(Camera state) 
	{
		for(ComponentCamera camera : cameras)
		{
			camera.setState(state);
		}
	}

	
	public void setDirection(DirectionCamera direction) 
	{
		for(ComponentCamera camera : cameras)
		{
			camera.setDirection(direction);
		}
	}
	
	
	public List<ComponentCamera> getSetCamera()
	{
		return cameras;
	}
	
	public DirectionCamera getDirection()
	{
		// Doesn't make sense ask for direction
		return null;
	}
	
	
	public static class Builder
	{
		private CompositeCamera composite;
		
		public Builder()
		{
			composite = new CompositeCamera();
		}
		
		
		public Builder addCamera(ComponentCamera camera)
		{
			composite.getSetCamera().add(camera);
			return this;
		}
		
		
		public CompositeCamera build() 
		{
			return composite;
		}
	}

}
