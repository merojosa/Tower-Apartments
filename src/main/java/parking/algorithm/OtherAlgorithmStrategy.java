package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public class OtherAlgorithmStrategy implements ParkingAlgorithmStrategy
{
	private ArrayList<Floor> floors;

	public ParkingSlot searchAvailableSlot(VehicleType vehicleType, int entrance)
	{
		int counterFloor = 0;
		int counterRight = 0;
		int counterLeft = 0;
		Floor currentFloor = null;

		// Iterate through floors
		while(counterFloor < floors.size())
		{			
			currentFloor = floors.get(counterFloor);
			
			counterRight = entrance;
			counterLeft = entrance;
			
			do
			{
				++counterRight;
				--counterLeft;
				
				if(counterRight >= currentFloor.getParkingSlots().size())
					counterRight = 0;
				
				if(counterLeft < 0)
					counterLeft = currentFloor.getParkingSlots().size() - 1;
				
				if(currentFloor.getSlot(counterRight).isSlotAvailable(vehicleType) == true)
				{
					return currentFloor.getSlot(counterRight);
				}
				else if(currentFloor.getSlot(counterLeft).isSlotAvailable(vehicleType) == true)
				{
					return currentFloor.getSlot(counterLeft);
				}
				
			} while( entrance != counterRight || entrance != counterLeft );
			
			counterFloor++;
		}
		
		return null;
	}
	
	public void setScenario(ArrayList<Floor> floors) 
	{
		this.floors = floors;
	}

}
