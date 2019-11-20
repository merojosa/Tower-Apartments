package parking;

import java.util.ArrayList;

public class Floor 
{
	ArrayList<ParkingSlot> slots;
	
	ArrayList<Integer> entradas;
	
	public Floor()
	{
		slots = new ArrayList<ParkingSlot>();
		entradas.add(0);
	}
	
	public ArrayList<ParkingSlot> getSlots()
	{
		return slots;
	}
}
