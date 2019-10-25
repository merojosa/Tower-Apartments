package security;

public class CameraImplementation implements Camera 
{
	private StateCamera state;
	
	public CameraImplementation(StateCamera state)
	{
		this.state = state;
	}
	
	public CameraImplementation(StateCamera state, DirectionCamera direction)
	{
		this.state = state;
		this.state.setDirection(direction);
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
