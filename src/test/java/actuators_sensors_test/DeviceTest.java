package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import actuators_sensors.Apartment;
import actuators_sensors.DeviceFactory;
import actuators_sensors.MovementFactory;
import actuators_sensors.TempFactory;

public class DeviceTest 
{
	DeviceFactory movementFactory;
	DeviceFactory tempFactory;
	
	@Before
	public void init()
	{
		movementFactory = new MovementFactory();
		tempFactory = new TempFactory();
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

}
