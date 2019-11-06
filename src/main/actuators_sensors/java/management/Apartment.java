package management;

import java.util.ArrayList;
import java.util.List;

import actions.ActionDeviceStrategy;
import construction_devices.Device;

public class Apartment 
{
	private List<Device> devices;
	private Mediator mediator;
	
	private Apartment()
	{
		devices = new ArrayList<Device>();
		mediator = new Mediator();
	}
	
	
	public List<Device> getDevices()
	{
		return devices;
	}
	
	
	public static class Builder
	{
		private Apartment apartment;
		
		public Builder()
		{
			apartment = new Apartment();
		}
		
		
		public Builder addDevice(Device device)
		{
			apartment.devices.add(device);
			return this;
		}
		
		public Builder addBehavior(ActionDeviceStrategy action, ActionDeviceStrategy answer)
		{
			// To add a behavior, both devices involved need to exist in the apartment.
			if( apartment.devices.contains(action.getDevice()) && apartment.devices.contains(answer.getDevice()) )
			{
				apartment.mediator.addBehavior(action, answer);
			}
			else
			{
				// Testing
				System.out.println("No se puede configurar el comportamiento porque faltan dispositivos.");
			}
			return this;
		}
		
		
		public Apartment build() 
		{
			return apartment;
		}
	}
}
