package construction_devices;

import actions.LightsOffAction;
import actions.LightsOnAction;
import management.MediatorApartment;

public class LightsActuator extends Device<Boolean>
{
	private boolean state;

	
	public LightsActuator(MediatorApartment mediator)
	{
		super(mediator);
	}
	
	@Override
	public void setState(Boolean state) 
	{
		this.state = state;
		
		if(state == true)
		{
			mediator.notifyAction(new LightsOnAction(this));
		}
		else
		{
			mediator.notifyAction(new LightsOffAction(this));
		}
	}
	
	public Boolean getState()
	{
		return state;
	}
}
