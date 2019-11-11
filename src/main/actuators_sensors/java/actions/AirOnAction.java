package actions;

import construction_devices.AirActuator;
import construction_devices.Device;

public class AirOnAction extends ActionDeviceCommand 
{	
	public AirOnAction(Device air)
	{
		super(air);
	}

	@Override
	public void execute() 
	{
		((AirActuator) device).turnOn();
	}

	@Override
	public String getKey() 
	{
		return getClass().getName() + "_" + true;
	}
}
