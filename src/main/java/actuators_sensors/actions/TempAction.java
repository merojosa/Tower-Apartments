package actions;

import construction_devices.Device;

public class TempAction extends ActionDeviceCommand<Integer>
{
	private int tempTrigger;
	
	
	public TempAction(int tempTrigger, Device<Integer> tempSensor)
	{
		super(tempSensor);
		this.tempTrigger = tempTrigger;
	}

	@Override
	public void execute()
	{
		device.setState(tempTrigger);
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + tempTrigger;
	}
}
