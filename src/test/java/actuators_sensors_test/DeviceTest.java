package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import actions.ActionDeviceCommand;
import actions.AirOnAction;
import actions.TempAction;
import construction_devices.AirActuator;
import construction_devices.AirFactory;
import construction_devices.DeviceFactory;
import construction_devices.LightsFactory;
import construction_devices.MovementFactory;
import construction_devices.TempFactory;
import construction_devices.TempSensor;
import management.Apartment;
import management.MediatorApartment;

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
		MediatorApartment mediator = new MediatorApartment();		
		Apartment apartment = new Apartment.Builder(mediator)
								.addDevice(tempFactory.create(mediator))
								.addDevice(airFactory.create(mediator))
								.build();
		
		Assert.assertSame(2, apartment.getDevices().size());
	}
	
	@Test 
	public void behaviorApartmentTest()
	{
		MediatorApartment mediator = new MediatorApartment();
		TempSensor temp = (TempSensor) tempFactory.create(mediator);
		AirActuator air = (AirActuator) airFactory.create(mediator);
		
		// When 31, the AC turns on.
		ActionDeviceCommand tempAction = new TempAction(31, temp);
		ActionDeviceCommand airAction = new AirOnAction(air);
		
		Apartment apartment = new Apartment.Builder(mediator)
								.addDevice(temp)
								.addDevice(air)
								.addBehavior(tempAction, airAction)
								.build();
		
		temp.setTemperature(25);
		Assert.assertFalse(air.getState());
		temp.setTemperature(31);
		Assert.assertTrue(air.getState());
	}
}
