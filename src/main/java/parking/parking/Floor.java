package parking;

import java.util.ArrayList;

public class Floor
{
	private ArrayList<ParkingSlot> slots;
	private ArrayList<Integer> entrances;
	
	private Floor()
	{
		this.slots = new ArrayList<ParkingSlot>();
		this.entrances = new ArrayList<Integer>();
	}
	
	public ArrayList<ParkingSlot> getParkingSlots()
	{
		return this.slots;
	}
	
	public ArrayList<Integer> getEntrances()
	{
		return this.entrances;
	}
	
	public ParkingSlot getSlot(int index)
	{
		return slots.get(index);
	}
	
	//----------------------construccion del piso-------------------------
	
	public static class Builder
	{
		private Floor floor;
		
		public Builder()
		{
			this.floor = new Floor();
		}
		
		public Builder addSlot(VehicleType type)
		{
			floor.getParkingSlots().add(new ParkingSlot(type));
			return this;
		}
		
		public Builder addSlots(int size, VehicleType type)
		{
			for(int counter = 0; counter < size; ++counter)
			{
				floor.getParkingSlots().add(new ParkingSlot(type));
			}
			
			return this;
		}
		
		public Floor build()
		{
			return floor;
		}
	}
}
