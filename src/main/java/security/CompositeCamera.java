package security;

import java.util.ArrayList;
import java.util.List;

public class CompositeCamera implements Camera
{
	private List<Camera> cameras;
	
	private CompositeCamera()
	{
		cameras = new ArrayList<Camera>();
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
	
	
	public void setCameras(List<Camera> cameras)
	{
		this.cameras = cameras;
	}
	
	
	public static class Builder
	{
		private CompositeCamera composite;
		
		public Builder()
		{
			composite = new CompositeCamera();
		}
		
		
		public Builder addCamera(Camera camera)
		{
			List<Camera> list = composite.getCameras();
			list.add(camera);
			return this;
		}
		
		
		public CompositeCamera build() 
		{
			return composite;
		}
	}

}
