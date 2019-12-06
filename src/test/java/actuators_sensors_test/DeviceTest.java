package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import actions.ActionDeviceCommand;
import actions.AirOnAction;
import actions.MakeSoundAction;
import actions.SmokeDetectedAction;
import actions.TempAction;
import construction_devices.AirFactory;
import construction_devices.AlarmFactory;
import construction_devices.Device;
import construction_devices.DeviceFactory;
import construction_devices.LightsFactory;
import construction_devices.SmokeFactory;
import construction_devices.TempFactory;
import management.Apartment;
import management.MediatorApartment;

public class DeviceTest 
{
	DeviceFactory<Integer> tempFactory;
	DeviceFactory<Boolean> lightsFactory;
	DeviceFactory<Boolean> airFactory;
	DeviceFactory<Boolean> smokeFactory;
	DeviceFactory<Boolean> alarmFactory;
	
	MediatorApartment mediator;
	Device<Integer> tempDevice;
	Device<Integer> tempDeviceNoAnswer;
	Device<Boolean> airDevice;
	Device<Boolean> airDeviceNoAnswer;
	Device<Boolean> smokeDevice;
	Device<Boolean> alarmDevice;

	
	ActionDeviceCommand<Integer> tempAction;
	ActionDeviceCommand<Integer> tempActionNoAnswer;
	ActionDeviceCommand<Boolean> airAction;
	ActionDeviceCommand<Boolean> airActionNoAnswer;
	ActionDeviceCommand<Boolean> smokeAction;
	ActionDeviceCommand<Boolean> makeSoundAction;
	
	
	Apartment apartment;
	
	@Before
	public void init()
	{
		tempFactory = new TempFactory();
		lightsFactory = new LightsFactory();
		airFactory = new AirFactory();
		smokeFactory = new SmokeFactory();
		alarmFactory = new AlarmFactory();
		
		mediator = new MediatorApartment();
		
		tempDevice = tempFactory.create(mediator);
		tempDeviceNoAnswer = tempFactory.create(mediator);
		airDevice = airFactory.create(mediator);
		airDeviceNoAnswer = airFactory.create(mediator);
		smokeDevice = smokeFactory.create(mediator);
		alarmDevice = alarmFactory.create(mediator);
		
		tempAction = new TempAction(31, tempDevice);
		tempActionNoAnswer = new TempAction(25, tempDeviceNoAnswer);
		airAction = new AirOnAction(airDevice);
		airActionNoAnswer =  new AirOnAction(airDeviceNoAnswer);
		smokeAction = new SmokeDetectedAction(smokeDevice);
		makeSoundAction = new MakeSoundAction(alarmDevice);
		
		apartment = new Apartment.Builder(mediator)
				.addDevice(tempDevice)
				.addDevice(tempDeviceNoAnswer)
				.addDevice(airDevice)
				.addDevice(airDeviceNoAnswer)
				.addDevice(smokeDevice)
				.addDevice(alarmDevice)
				.build();
		
		apartment.addBehavior(tempAction, airAction);
		apartment.addBehavior(tempActionNoAnswer, airActionNoAnswer);
		apartment.addBehavior(smokeAction, makeSoundAction);
	}

	@Test
	public void apartmentConstruction()
	{
		MediatorApartment mediator_construction = new MediatorApartment();		
		Apartment apartment_construction = new Apartment.Builder(mediator_construction)
								.addDevice(tempFactory.create(mediator_construction))
								.addDevice(airFactory.create(mediator_construction))
								.build();
		
		Assert.assertSame(2, apartment_construction.getDevices().size());
	}
	
	@Test 
	public void temperatureTest()
	{		
		tempDevice.setState(25);
		Assert.assertFalse(airDevice.getState());
		
		tempDevice.setState(31);
		Assert.assertFalse(airDeviceNoAnswer.getState());
		Assert.assertTrue(airDevice.getState());
	}
	
	@Test
	public void smokeTest()
	{
		Assert.assertFalse(alarmDevice.getState());
		smokeDevice.setState(true);
		Assert.assertTrue(alarmDevice.getState());		
	}
}
