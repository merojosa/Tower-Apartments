package security;

public class LeafCamera implements ComponentCamera 
{
	private StateCamera state;
	
	public LeafCamera(StateCamera state)
	{
		this.state = state;
	}
	
	
	public LeafCamera(StateCamera state, DirectionCamera direction)
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
