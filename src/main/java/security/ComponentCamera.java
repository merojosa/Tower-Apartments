package security;

import java.util.List;

public interface ComponentCamera 
{
	public void setState(Camera state);
	public void setDirection(DirectionCamera direction);
	public List<ComponentCamera> getSetCamera();
	public PropertiesCamera getProperties();
}
