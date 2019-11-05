package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import actions.ActionDevice;
import actions.AirOnAction;
import actions.TempAction;
import construction_devices.AirFactory;
import construction_devices.DeviceFactory;
import construction_devices.LightsFactory;
import construction_devices.MovementFactory;
import construction_devices.TempFactory;
import management.Apartment;
import management.Mediator;

public class DeviceTest 
{
	DeviceFactory movementFactory;
	DeviceFactory tempFactory;
	DeviceFactory lightsFactory;
	DeviceFactory airFactory;
	
	@Before
	public void init()
	{
		movementFactory = new MovementFactory();
		tempFactory = new TempFactory();
		lightsFactory = new LightsFactory();
		airFactory = new AirFactory();
	}

	@Test
	public void apartmentConstruction()
	{
		Apartment apartment = new Apartment.Builder()
								.addDevice(movementFactory.create())
								.addDevice(tempFactory.create())
								.build();
		
		Assert.assertSame(2, apartment.getDevices().size());
	}
	
	@Test
	public void setSensorBehaviorsTest()
	{
		Mediator mediator = new Mediator();
		ActionDevice tempAction = new TempAction(30, lightsFactory.create());
		mediator.addBehavior(tempAction.generateKey(), new AirOnAction(true, airFactory.create()));		
	}

}
