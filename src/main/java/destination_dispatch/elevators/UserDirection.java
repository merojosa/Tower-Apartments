package elevators;
public class UserDirection {
	public int userDestination;
	public int userFloor; 
	public Direction direction; 
	
	public UserDirection(int currentFloor, int destination) {
		this.userFloor = currentFloor; 
		this.userDestination = destination; 
		
		if(currentFloor > destination) {
			this.direction = Direction.DOWN; 
		}else if(currentFloor < destination){
			this.direction = Direction.UP; 
		}else {
			this.direction = Direction.NOMOVE; 
		}
	}
	
	public int getCurrentFloor() {
		return this.userFloor;
	}
	
	public int getDestinationFloor() {
		return this.userDestination;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
