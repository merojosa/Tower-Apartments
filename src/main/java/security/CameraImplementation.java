package security;

public class CameraImplementation implements Camera 
{
	private StateCamera state;
	
	public CameraImplementation(StateCamera state)
	{
		this.state = state;
	}
	
	public void setState(StateCamera state) 
	{
		this.state = state;
	}

	
	public void setDirection(DirectionCamera direction) 
	{
		this.state.setDirection(direction);
	}
	
	public StateCamera getState()
	{
		return state;
	}
}
