package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public class EasyAlgorithm implements ParkingAlgorithm 
{

	// If it's full, it will begin in the next floor, same position
	public ParkingSlot searchSlotAvailable(VehicleType vehicleType, ArrayList<Floor> floors, int entrance ) 
	{
		int counterFloor = 0;
		int counterSlot = 0;
		Floor currentFloor = null;

		// Iterate through floors
		while(counterFloor < floors.size())
		{
			counterSlot = entrance + 1;
			currentFloor = floors.get(counterFloor);
			do
			{				
				if(currentFloor.getParkingSlots().get(counterSlot).isSlotAvailable(vehicleType) == true)
				{
					return currentFloor.getParkingSlots().get(counterSlot);
				}
				
				++counterSlot;
				
				if(counterSlot >= currentFloor.getParkingSlots().size())
				{
					counterSlot = 0;
				}
				
			} while( entrance != counterSlot );
			
			counterFloor++;
		}
		
		return null;
	}

}
