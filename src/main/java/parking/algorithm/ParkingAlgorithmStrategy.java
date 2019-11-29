package algorithm;

import java.util.ArrayList;

import parking.Floor;
import parking.ParkingSlot;
import parking.VehicleType;

public interface ParkingAlgorithmStrategy
{
	public ParkingSlot searchAvailableSlot(VehicleType vehicleType, int entrance);
	
	public void setScenario(ArrayList<Floor> floors);
}
