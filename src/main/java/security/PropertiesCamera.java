package security;

import java.util.List;
import java.util.ArrayList;

public class PropertiesCamera 
{
	// Aqui podria haber mas propiedades como las personas enfocadas, etc...
	private DirectionCamera direction;
	private LocationCamera location;
	private List<String> actualIDs;
	
	public PropertiesCamera()
	{
		direction = DirectionCamera.CENTER;
		location = LocationCamera.LIVINGROOM;
		actualIDs = new ArrayList<String>();
	}
	
	public DirectionCamera getDirection()
	{
		return direction;
	}
	
	public void setDirection(DirectionCamera direction)
	{
		this.direction = direction;
	}
	
	public LocationCamera getLocation()
	{
		return location;
	}
	
	public void setLocation(LocationCamera location)
	{
		this.location = location;
	}
	
	public void addID(String ID)
	{
		actualIDs.add(ID);
	}
	
	public boolean containID(String ID)
	{
		return actualIDs.contains(ID);
	}
}
