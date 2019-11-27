package destination_dispatch_test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Algorithm.DispatcherAlgorithm;
import Algorithm.DistanceAlgorithm;
import elevators.Direction;
import elevators.Dispatcher;
import elevators.Elevator;
import elevators.UserDirection;
import elevators.UserType;

public class ElevatorTest {
	DispatcherAlgorithm algorithm;
	Dispatcher dispatcher;
	
	@Before
	public void init() {
		algorithm = new DistanceAlgorithm();
	}
	
	@Test
	public void dispatcherCreation() {
		Elevator elevator1 = new Elevator.Builder(1)
				.setCurrentFloor(3, 3)
				.setType(UserType.NORMAL)
				.setDirection(Direction.NOMOVE)
				.build();
		
		Elevator elevator2 = new Elevator.Builder(2)
				.setCurrentFloor(2, 5)
				.setType(UserType.PREMIUM)
				.setDirection(Direction.UP)
				.build();
		
		Elevator elevator3 = new Elevator.Builder(3)
				.setCurrentFloor(2, 3)
				.setType(UserType.NORMAL)
				.addFloorDestination(4)
				.addFloorDestination(5)
				.setDirection(Direction.UP).build();
		
		dispatcher = new Dispatcher.Builder()
				.addElevator(elevator1)
				.addElevator(elevator2)
				.addElevator(elevator3)
				.setNumFloor(5)
				.addFloor(UserType.NORMAL, 1)
				.addFloor(UserType.NORMAL, 2)
				.addFloor(UserType.NORMAL, 3)
				.addFloor(UserType.PREMIUM, 4)
				.addFloor(UserType.NORMAL, 5)
				.build();
		
		Assert.assertSame(3, dispatcher.getElevators().size());
		Assert.assertSame(5, dispatcher.getTotalFloors());
	}
	
	@Test
	public void userTypeRequestTestFail() {
		//Si el usuario normal trata de ir a un piso al que no puede
		Elevator elevator1 = new Elevator.Builder(1)
				.setCurrentFloor(3, 3)
				.setType(UserType.NORMAL)
				.setDirection(Direction.NOMOVE)
				.build();
		
		Elevator elevator2 = new Elevator.Builder(2)
				.setCurrentFloor(2, 5)
				.setType(UserType.PREMIUM)
				.setDirection(Direction.UP)
				.build();
		
		Elevator elevator3 = new Elevator.Builder(3)
				.setCurrentFloor(2, 3)
				.setType(UserType.NORMAL)
				.addFloorDestination(4)
				.addFloorDestination(5)
				.setDirection(Direction.UP).build();
		
		dispatcher = new Dispatcher.Builder()
				.addElevator(elevator1)
				.addElevator(elevator2)
				.addElevator(elevator3)
				.setNumFloor(5)
				.addFloor(UserType.NORMAL, 1)
				.addFloor(UserType.NORMAL, 2)
				.addFloor(UserType.NORMAL, 3)
				.addFloor(UserType.PREMIUM, 4)
				.addFloor(UserType.NORMAL, 5)
				.build();
		
		UserDirection userDirection = new UserDirection(1, 4);

		int elevatorID = algorithm.requestElevator(userDirection, UserType.NORMAL, dispatcher);
		
		Assert.assertSame(-1, elevatorID);
	}
	
	@Test
	public void userTypeRequestTest() {
		
		Elevator elevator1 = new Elevator.Builder(1)
				.setCurrentFloor(5, 2)
				.setType(UserType.NORMAL)
				.setDirection(Direction.DOWN)
				.build();
		
		Elevator elevator2 = new Elevator.Builder(2)
				.setCurrentFloor(2, 5)
				.setType(UserType.PREMIUM)
				.setDirection(Direction.UP)
				.build();
		
		Elevator elevator3 = new Elevator.Builder(3)
				.setCurrentFloor(1, 3)
				.setType(UserType.NORMAL)
				.addFloorDestination(4)
				.addFloorDestination(5)
				.setDirection(Direction.UP).build();
		
		dispatcher = new Dispatcher.Builder()
				.addElevator(elevator1)
				.addElevator(elevator2)
				.addElevator(elevator3)
				.setNumFloor(5)
				.addFloor(UserType.NORMAL, 1)
				.addFloor(UserType.NORMAL, 2)
				.addFloor(UserType.NORMAL, 3)
				.addFloor(UserType.PREMIUM, 4)
				.addFloor(UserType.NORMAL, 5)
				.build();
		
		UserDirection userDirection = new UserDirection(1, 5);

		int elevatorID = algorithm.requestElevator(userDirection, UserType.NORMAL, dispatcher);
				
		Assert.assertNotEquals(-1, elevatorID);
	}
}
