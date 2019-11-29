package parking;

import java.util.ArrayList;

import algorithm.ParkingAlgorithmStrategy;

public class Parking 
{
	private ArrayList<Floor> parkingFloors;
	
	private ParkingAlgorithmStrategy strategy;
	
	private Parking()
	{
		this.parkingFloors = new ArrayList<Floor>();
	}
	
	public void setStrategy(ParkingAlgorithmStrategy strategy)
	{
		this.strategy = strategy;
		this.strategy.setScenario(parkingFloors);
	}
	
	public ParkingSlot searchAvailableSlot(VehicleType vehicleType, int entrance)
	{
		return strategy.searchAvailableSlot(vehicleType, entrance);
	}
	
	public ArrayList<Floor> getFloors()
	{
		return this.parkingFloors;
	}
	

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
