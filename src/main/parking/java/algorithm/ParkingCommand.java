package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public interface ParkingAlgorithm
{
	public ParkingSlot searchField(VehicleType vehicle, ArrayList<Floor> floors, int entrance);
}
