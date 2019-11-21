package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public interface ParkingAlgorithm
{
	public ParkingSlot searchSlotAvailable(VehicleType vehicleType, ArrayList<Floor> floors, int entrance);
}
