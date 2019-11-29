package actions;

import construction_devices.Device;
import construction_devices.LightsActuator;

public class LightsOffAction extends ActionDeviceCommand
{

	public LightsOffAction(Device lights)
	{
		super(lights);
	}

	@Override
	public void execute() 
	{
		((LightsActuator) device).turnOff();
	}

	@Override
	protected String getImplementedKey()
	{
		return getPartialKey() + "_" + false;
	}

}
