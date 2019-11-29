package actions;

import construction_devices.AlarmActuator;
import construction_devices.Device;

public class MakeSoundAction extends ActionDeviceCommand {

	public MakeSoundAction(Device alarm)
	{
		super(alarm);
	}

	@Override
	public void execute() 
	{
		((AlarmActuator) device).makeSound();
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + true;
	}

}
