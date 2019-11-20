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
	
	//----------------------construcción del piso-------------------------
	
	public static class Builder
	{
		private Floor floor;
		
		public Builder()
		{
			this.floor = new Floor();
		}
		
		public Builder addSlot(ParkingSlot slot)
		{
			floor.getParkingSlots().add(slot);
			return this;
		}
		
		public Floor build()
		{
			return floor;
		}
	}
}
