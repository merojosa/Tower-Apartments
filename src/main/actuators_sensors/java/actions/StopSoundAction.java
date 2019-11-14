package actions;

import construction_devices.AlarmActuator;
import construction_devices.Device;

public class StopSoundAction extends ActionDeviceCommand
{

	public StopSoundAction(Device alarm) 
	{
		super(alarm);
	}

	@Override
	public void execute() 
	{
		((AlarmActuator) device).stopSound();		
	}

	@Override
	public String getKey() 
	{
		return getClass().getName() + "_" + true;
	}

}