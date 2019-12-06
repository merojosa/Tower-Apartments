package construction_devices;


import actions.TempAction;
import management.MediatorApartment;

public class TempSensor extends Device<Integer>
{
	private int temperature;


	public TempSensor(MediatorApartment mediator) 
	{
		super(mediator);
	}

	
	@Override
	public void setState(Integer state) 
	{
		temperature = state;
		mediator.notifyAction(new TempAction(state, this));		
	}

	
	@Override
	public Integer getState() 
	{
		return temperature;
	}
}
