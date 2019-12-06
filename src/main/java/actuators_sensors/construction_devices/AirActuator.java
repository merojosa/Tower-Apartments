package construction_devices;

import actions.AirOffAction;
import actions.AirOnAction;
import management.MediatorApartment;

public class AirActuator extends Device<Boolean>
{	
	private boolean state;

	
	public AirActuator(MediatorApartment mediator) 
	{
		super(mediator);
	}


	@Override
	public void setState(Boolean state) 
	{
		this.state = state;

		if(state == true)
		{
			mediator.notifyAction(new AirOnAction(this));
		}
		else
		{
			mediator.notifyAction(new AirOffAction(this));
		}
	}


	@Override
	public Boolean getState() 
	{
		return state;
	}

	
	
	

}
