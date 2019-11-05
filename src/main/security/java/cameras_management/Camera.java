package cameras_management;

public enum Camera 
{
	ON
	{

		@Override
		public void setDirection(DirectionCamera direction) 
		{
			this.properties.setDirection(direction);
			System.out.println("Se cambio la direccion a " + this.properties.getDirection());
		}
		
	},
	OFF
	{

		@Override
		public void setDirection(DirectionCamera direction)
		{
			System.out.println("No se puede cambiar la direccion estando la camara apagada.");
		}
		
	};
	

	protected PropertiesCamera properties;
	
	Camera()
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
