package actions;

import construction_devices.Device;

public class MovementDetectedAction extends ActionDeviceCommand<Boolean>
{
	public MovementDetectedAction(Device<Boolean> device)
	{
		super(device);
	}

	public void execute() 
	{
		device.setState(true);
	}

	@Override
	protected String getImplementedKey()
	{
		return getPartialKey() + "_" + true;
	}

}
