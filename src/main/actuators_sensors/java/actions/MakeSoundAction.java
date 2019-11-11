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
	public String getKey() 
	{
		// TODO Auto-generated method stub
		return getClass().getName() + "_" + true;
	}

}
