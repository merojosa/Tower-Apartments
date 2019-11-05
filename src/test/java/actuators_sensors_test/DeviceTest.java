package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import actuators_sensors.ActionDevice;
import actuators_sensors.AirFactory;
import actuators_sensors.AirOnAction;
import actuators_sensors.Apartment;
import actuators_sensors.DeviceFactory;
import actuators_sensors.LightsFactory;
import actuators_sensors.Mediator;
import actuators_sensors.MovementFactory;
import actuators_sensors.TempAction;
import actuators_sensors.TempFactory;

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
