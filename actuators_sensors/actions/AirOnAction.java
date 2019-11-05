package actions;

import construction_devices.AirActuator;
import construction_devices.Device;

public class AirOnAction extends ActionDevice 
{
	private AirActuator air;
	
	
	public AirOnAction(boolean state, Device air)
	{
		this.air = (AirActuator) air;
		strategy = new AirStrategy(state);
	}

	@Override
	public void execute() 
	{
		air.turnOn();
	}
	
	// La clase no tiene que estar adentro sino en un archivo a parte.
}
