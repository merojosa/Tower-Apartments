package parking;

public class ParkingSlot 
{
	private VehicleType vehicleType;
	private boolean occupiedSlot;
	
	public ParkingSlot(VehicleType vehicleType)
	{
		this.vehicleType = vehicleType;
		occupiedSlot = false;
	}
	
	public VehicleType getVehicleType()
	{
		return this.vehicleType;
	}
	
	public boolean isOcuppied()
	{
		return this.occupiedSlot;
	}
	
	public void setOccupied(boolean occupiedState)
	{
		this.occupiedSlot = occupiedState;
	}
	
	public boolean isSlotAvailable(VehicleType vehicleType)
	{
		if(isOcuppied() == false && this.vehicleType == vehicleType)
		{
			return true;
		}
		
		return false;
	}
}
