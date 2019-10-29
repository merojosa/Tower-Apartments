package security;

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
