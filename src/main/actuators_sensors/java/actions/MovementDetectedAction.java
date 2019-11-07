package actions;

import construction_devices.Device;
import construction_devices.MovementSensor;

public class MovementDetectedAction extends ActionDeviceCommand
{
	public MovementDetectedAction(Device device)
	{
		super(device);
	}

	public void execute() 
	{
		((MovementSensor) device).detectMotion();
	}

	@Override
	public String getKey()
	{
		return getClass().getName() + "_" + true;
	}

}
