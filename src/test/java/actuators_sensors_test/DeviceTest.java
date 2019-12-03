package actuators_sensors_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import actions.ActionDeviceCommand;
import actions.AirOnAction;
import actions.MakeSoundAction;
import actions.SmokeDetectedAction;
import actions.TempAction;
import construction_devices.AirActuator;
import construction_devices.AirFactory;
import construction_devices.AlarmActuator;
import construction_devices.AlarmFactory;
import construction_devices.DeviceFactory;
import construction_devices.LightsFactory;
import construction_devices.MovementFactory;
import construction_devices.SmokeFactory;
import construction_devices.SmokeSensor;
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
	DeviceFactory smokeFactory;
	DeviceFactory alarmFactory;
	
	MediatorApartment mediator;
	TempSensor tempDevice;
	TempSensor tempDeviceNoAnswer;
	AirActuator airDevice;
	AirActuator airDeviceNoAnswer;
	SmokeSensor smokeDevice;
	AlarmActuator alarmDevice;

	
	ActionDeviceCommand tempAction;
	ActionDeviceCommand tempActionNoAnswer;
	ActionDeviceCommand airAction;
	ActionDeviceCommand airActionNoAnswer;
	ActionDeviceCommand smokeAction;
	ActionDeviceCommand makeSoundAction;
	
	
	Apartment apartment;
	
	@Before
	public void init()
	{
		movementFactory = new MovementFactory();
		tempFactory = new TempFactory();
		lightsFactory = new LightsFactory();
		airFactory = new AirFactory();
		smokeFactory = new SmokeFactory();
		alarmFactory = new AlarmFactory();
		
		mediator = new MediatorApartment();
		
		tempDevice = (TempSensor) tempFactory.create(mediator);
		tempDeviceNoAnswer = (TempSensor) tempFactory.create(mediator);
		airDevice = (AirActuator) airFactory.create(mediator);
		airDeviceNoAnswer = (AirActuator) airFactory.create(mediator);
		smokeDevice = (SmokeSensor) smokeFactory.create(mediator);
		alarmDevice = (AlarmActuator) alarmFactory.create(mediator);
		
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
				.addBehavior(tempAction, airAction)
				.addBehavior(tempActionNoAnswer, airActionNoAnswer)
				.addBehavior(smokeAction, makeSoundAction)
				.build();
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
		tempDevice.setTemperature(25);
		Assert.assertFalse(airDevice.getState());
		
		tempDevice.setTemperature(31);
		Assert.assertFalse(airDeviceNoAnswer.getState());
		Assert.assertTrue(airDevice.getState());
	}
	
	@Test
	public void smokeTest()
	{
		Assert.assertFalse(alarmDevice.getSound());
		smokeDevice.detectSmoke();
		Assert.assertTrue(alarmDevice.getSound());		
	}
}
