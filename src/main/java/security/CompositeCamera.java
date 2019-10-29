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

	
	// REVISAR SI CON EL CAMBIO SE CAMBIAN LAS PROPIEDADES.
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
	
	
	public List<ComponentCamera> getCameras()
	{
		return cameras;
	}
	
	
	public void setCameras(List<ComponentCamera> cameras)
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
		
		
		public Builder addCamera(ComponentCamera camera)
		{
			composite.getCameras().add(camera);
			return this;
		}
		
		
		public CompositeCamera build() 
		{
			return composite;
		}
	}

}
