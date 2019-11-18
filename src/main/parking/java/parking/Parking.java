package parking;

import java.util.ArrayList;

public class Parking 
{
	private ArrayList<ParkingSlot> parkingSlots;
	
	private Parking()
	{
		this.parkingSlots = new ArrayList<ParkingSlot>();
	}
	
	public ArrayList<ParkingSlot> getParkingSlots()
	{
		return this.parkingSlots;
	}
	
	/*------------construcción del parqueo----------------------*/
	public static class Builder
	{
		private Parking parking;
		
		public Builder()
		{
			this.parking = new Parking();
		}
		
		public Builder addSlot(ParkingSlot slot)
		{
			parking.getParkingSlots().add(slot);
			return this;
		}
		
		public Parking build()
		{
			return parking;
		}
	}
	
}
