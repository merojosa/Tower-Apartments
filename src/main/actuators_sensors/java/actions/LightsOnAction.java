package actions;

import construction_devices.Device;
import construction_devices.LightsActuator;

public class LightsOnAction extends ActionDeviceCommand 
{

	public LightsOnAction(Device lights)
	{
		super(lights);
	}

	@Override
	public void execute()
	{
		((LightsActuator) device).turnOn();
	}

	@Override
	protected String getImplementedKey() 
	{	
		return getPartialKey() + "_" + true;
	}

}
