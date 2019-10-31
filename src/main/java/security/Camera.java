package security;

public enum Camera 
{
	ON
	{

		@Override
		public void setDirection(DirectionCamera direction) 
		{
			this.properties.setDirection(direction);
			System.out.println("Se cambi� la direcci�n a " + this.properties.getDirection());
		}
		
	},
	OFF
	{

		@Override
		public void setDirection(DirectionCamera direction)
		{
			System.out.println("No se puede cambiar la direcci�n estando la c�mara apagada.");
		}
		
	};
	

	// Propiedades, aqui podria estar las personas actuales que tiene la camara, etc.
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
}
