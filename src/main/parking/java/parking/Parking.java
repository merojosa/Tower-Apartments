package parking;

import java.util.ArrayList;

public class Parking 
{
	private ArrayList<Floor> parkingFloors;
	
	private Parking()
	{
		this.parkingFloors = new ArrayList<Floor>();
	}
	
	public ArrayList<Floor> getFloors()
	{
		return this.parkingFloors;
	}
	
	/*------------construcción del parqueo----------------------*/
	public static class Builder
	{
		private Parking parking;
		
		public Builder()
		{
			this.parking = new Parking();
		}
		
		public Builder addFloor(Floor floor)
		{
			parking.getFloors().add(floor);
			return this;
		}
		
		public Builder addEntrances(ArrayList<Integer> entrances)
		{
			for(Floor floor : parking.getFloors())
			{
				floor.getEntrances().addAll(entrances);
			}
			
			return this;
		}
		
		public Parking build()
		{
			return parking;
		}
	}
	
}
