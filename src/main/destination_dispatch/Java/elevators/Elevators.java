package elevators;

public class Elevator{
	
	public int currentFloor; 
	public int destinationFloor; 
	public userType type; 
	public int id; 
	
	public Elevator() {
		
	}
	
	
	public static class Builder{
		private Elevator elevator;
		
		public Builder(int id) {
			this.elevator = new Elevator();
			this.elevator.id = id;
			return this;
		}
		
		public Builder setConfiguration(int currentfloor1, int dest) {
			this.elevator.currentFloor = currentfloor1;
			this.elevator.destinationFloor = dest;
			return this;
		}
		
		public Builder setType(userType type2) {
			this.elevator.type = type2;
			return this;
		}
		
		public Elevator build() {
			return this.elevator;
		}
	}
	


}

