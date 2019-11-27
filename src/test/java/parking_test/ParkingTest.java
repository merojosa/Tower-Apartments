package parking_test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algorithm.EasyAlgorithmStrategy;
import algorithm.OtherAlgorithmStrategy;
import parking.Floor;
import parking.Parking;
import parking.ParkingSlot;
import parking.VehicleType;

public class ParkingTest
{
	Parking parkingOneFloor;
	Parking fullParking;
	Parking someFloorsParking;
	
	@Before
	public void init() 
	{
		Floor someTypesFloor = new Floor.Builder()
				.addSlots(4, VehicleType.SEDAN)
				.addSlots(2, VehicleType.MOTORCYCLE)
				.build();

		someTypesFloor.getParkingSlots().get(0).setOccupied(true);
		someTypesFloor.getParkingSlots().get(3).setOccupied(true);
		someTypesFloor.getParkingSlots().get(5).setOccupied(true);

		ArrayList<Integer> entrances = new ArrayList<Integer>();
		entrances.add(0);

		parkingOneFloor = new Parking.Builder()
					.addFloor(someTypesFloor)
					.addEntrances(entrances)
					.build();
		
		Floor fullFloor = new Floor.Builder()
						.addSlots(3, VehicleType.SEDAN)
						.build();
		
		fullFloor.getParkingSlots().get(0).setOccupied(true);
		fullFloor.getParkingSlots().get(1).setOccupied(true);
		fullFloor.getParkingSlots().get(2).setOccupied(true);
		
		fullParking = new Parking.Builder()
				.addFloor(fullFloor)
				.addEntrances(entrances)
				.build();
		
		someFloorsParking = new Parking.Builder()
								.addFloor(fullFloor)
								.addFloor(someTypesFloor)
								.build();
	}

	@Test
	public void oneFloorTest() 
	{
		parkingOneFloor.setStrategy(new EasyAlgorithmStrategy());
		ParkingSlot slot = parkingOneFloor.searchAvailableSlot(VehicleType.MOTORCYCLE, 0);
		Assert.assertNotSame(null, slot);
	}
	
	@Test
	public void FullParkingTest() 
	{
		fullParking.setStrategy(new EasyAlgorithmStrategy());
		ParkingSlot slot = fullParking.searchAvailableSlot(VehicleType.SEDAN, 0);
		Assert.assertSame(null, slot);
	}
	
	@Test
	public void twoFloorsTest()
	{
		someFloorsParking.setStrategy(new EasyAlgorithmStrategy());
		ParkingSlot slot = someFloorsParking.searchAvailableSlot(VehicleType.SEDAN, 0);
		Assert.assertNotSame(null, slot);
	}
	
	@Test
	public void searchWithOtherStrategyTest()
	{
		// Pendiente de implementar
		someFloorsParking.setStrategy(new OtherAlgorithmStrategy());
		ParkingSlot slot = someFloorsParking.searchAvailableSlot(VehicleType.MOTORCYCLE, 0);
		//Assert.assertNotSame(null, slot);

	}
}
