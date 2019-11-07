package actions;

import construction_devices.Device;
import construction_devices.TempSensor;

public class TempAction extends ActionDeviceStrategy
{
	private int tempTrigger;
	
	
	public TempAction(int tempTrigger, Device tempSensor)
	{
		super(tempSensor);
		this.tempTrigger = tempTrigger;
	}

	@Override
	public void execute()
	{
		((TempSensor) device).setTemperature(tempTrigger);
	}

	@Override
	public String getKey() 
	{
		return getClass().getName() + "_" + tempTrigger;
	}
}
