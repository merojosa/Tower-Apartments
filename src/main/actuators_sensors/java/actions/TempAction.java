package actions;

import construction_devices.Device;
import construction_devices.TempSensor;

public class TempAction extends ActionDevice
{
	TempSensor tempSensor;
	private int tempTrigger;
	
	
	public TempAction(int tempTrigger, Device tempSensorlights)
	{
		this.tempTrigger = tempTrigger;
		strategy = new TempStrategy(tempTrigger);
		this.tempSensor = (TempSensor) tempSensor;
	}

	@Override
	public void execute()
	{
		tempSensor.setTemperature(tempTrigger);
	}
}
