package actions;

import construction_devices.AirActuator;
import construction_devices.Device;

public class AirOffAction extends ActionDeviceCommand {

	public AirOffAction(Device air) 
	{
		super(air);
	}

	@Override
	public void execute() 
	{
		((AirActuator) device).turnOff();
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + false;
	}

}
