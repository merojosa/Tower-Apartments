package management;

import java.util.ArrayList;
import java.util.List;

import construction_devices.Device;

public class Apartment 
{
	private List<Device> devices;
	
	private Apartment()
	{
		devices = new ArrayList<Device>();
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
		
		
		public Apartment build() 
		{
			return apartment;
		}
	}
}
