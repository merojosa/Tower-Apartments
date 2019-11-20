package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public class EasyAlgorithm implements ParkingAlgorithm 
{

	public ParkingSlot searchField(VehicleType vehicle, ArrayList<Floor> floors, int entrance ) 
	{
		Floor floor = null;
		int counterFloor = 0;
		int counterSlot = 0;
		
		while(counterFloor < floors.size())
		{
			counterSlot = 0;
			
			while(counterSlot < floors.get(counterSlot).getSlots().size())
			{
			}
			
			++counterFloor;
		}
		
		return null;
	}

}
