package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public class EasyAlgorithmStrategy implements ParkingAlgorithmStrategy 
{
	private ArrayList<Floor> floors;

	// If it's full, it will begin in the next floor, same position
	public ParkingSlot searchAvailableSlot(VehicleType vehicleType, int entrance ) 
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
	
	public void setScenario(ArrayList<Floor> floors) 
	{
		this.floors = floors;
	}

}
