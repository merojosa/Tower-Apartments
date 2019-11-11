import actions.ActionDeviceCommand;
import construction_devices.Device;
import construction_devices.LightsActuator;

public class LightsOffAction extends ActionDeviceCommand {

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
	public String getKey()
	{
		return getClass().getName() + "_" + false;	
	}

}
