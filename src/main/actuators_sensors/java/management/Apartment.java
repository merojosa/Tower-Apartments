package management;

import java.util.ArrayList;
import java.util.List;

import actions.ActionDeviceStrategy;
import construction_devices.Device;

public class Apartment 
{
	private List<Device> devices;
	private Mediator mediator;
	
	private Apartment(Mediator mediator)
	{
		devices = new ArrayList<Device>();
		this.mediator = mediator;
	}
	
	
	public List<Device> getDevices()
	{
		return devices;
	}
	
	
	public static class Builder
	{
		private Apartment apartment;
		
		public Builder(Mediator mediator)
		{
			apartment = new Apartment(mediator);
		}
		
		
		public Builder addDevice(Device device)
		{
			// Both mediators needs to be the same (same reference, so that, == it's ok)
			if(device.getMediator() == apartment.mediator)
			{
				apartment.devices.add(device);
			}
			else
			{
				System.out.println("Mediator distinto.");
			}
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
