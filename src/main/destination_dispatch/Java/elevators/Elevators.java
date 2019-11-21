package elevators;

import java.util.ArrayList;

public class Elevator{
	
	public int currentFloor; 
	public Arraylist<Integer> destinationFloors; 
	public userType type; 
	public int id; 
	public direction direction; 
	
	public Elevator(int id) {
		this.elevator.id = id;
		this.destinationFloors = = new ArrayList<Integer>();
	}
	
	public static class Builder{
		private Elevator elevator;
		
		//Id incrementable
		public Builder(int id) {
			this.elevator = new Elevator(id);
			return this;
		}
		
		public Builder setCurrentFloor(int currentfloor, int dest) {
			this.elevator.currentFloor = currentfloor;
			this.elevator.destinationFloor = dest;
			return this;
		}
		
		public Builder addFloorDestination(int floor) {
			this.elevator.destinationFloors.add(floor); 
			return this; 
		}
		
		public Builder setType(userType type2) {
			this.elevator.type = type2;
			return this;
		}
		
		public Builder setDirection(Direction direction) {
			this.elevator.direction = direction; 
		}
		
		public Elevator build() {
			return this.elevator;
		}
	}
	


}

