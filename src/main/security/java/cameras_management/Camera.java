package cameras_management;

public abstract class Camera 
{
	protected PropertiesCamera properties;
	
	public Camera()
	{
		// By default, the direction is center.
		properties = new PropertiesCamera();		
	}
	
	public DirectionCamera getDirection()
	{
		return properties.getDirection();
	}
	
	public PropertiesCamera getProperties()
	{
		return this.properties;
	}
	
	public void setProperties(PropertiesCamera properties)
	{
		this.properties = properties;
	}
	
	public abstract void setDirection(DirectionCamera direction);
	
	
	public class PropertiesCamera
	{
		// Aqui podria haber mas propiedades como las personas enfocadas, etc...
		private DirectionCamera direction;
		
		public PropertiesCamera()
		{
			direction = DirectionCamera.CENTER;
		}
		
		public DirectionCamera getDirection()
		{
			return direction;
		}
		
		public void setDirection(DirectionCamera direction)
		{
			this.direction = direction;
		}
	}
}
