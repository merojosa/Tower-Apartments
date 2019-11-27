package elevators;

import java.util.ArrayList;

public class Elevator{
	
	private static int timeBetweenFloors = 5;
	private static int timeStopsInFloor = 10;
	
	public int currentFloor; 
	public Arraylist<Integer> destinationFloors; 
	public userType type; 
	public int id; 
	public direction direction; 
	
	public Elevator(int id) {
		this.elevator.id = id;
		this.destinationFloors = new ArrayList<Integer>();
	}
	
	public void addDestination(int floor) {
		this.destinationFloors.add(floor);
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
	
	public int getID() {
		return this.id;
	}
	
	public int getArrivalTime(UserDirection userDirection) {
		int distance = 0; 
		int totalTime = 0;
		//Si el elevador no se mueve
		if(this.direction == Direction.NOMOVE) {
			//La distancia sera de el piso actual del elevador menos el piso actual del usuario en valor abs
			distance = Math.abs((this.currentFloor - userDirection.getCurrentFloor()));
		}
		//Si el elevador esta por debajo del usuario
		if(this.currentFloor < userDirection.getCurrentFloor()) {
			distance = this.elevatorBelowUser(userDirection);
		}
		//Si el elevador esta por encima del usuario
		else if(this.currentFloor > userDirection.getCurrentFloor()) {
			distance = this.elevatorAboveUser(userDirection);
		}
		
		//Tiempo total, cantidad de pisos a los que tiene que viajar + cantidad de paradas, 
		totalTime = (distance*timeBetweenFloors) + (this.destinationFloors.size()*timeStopsInFloor);
		return totalTime;
	}
	
	public int elevatorBelowUser(UserDirection userDirection) {
		int distance = 0;
		
		//SI el usuario va para arriba
		if(userDirection.getDirection() == Direction.UP) {
			
			//Si el elevador va para arriba
			if(this.direction == Direction.UP) {
				distance = Math.abs((this.currentFloor - userDirection.getCurrentFloor()));
				return distance;
			
			//Si el elevador va para abajo(direccion contraria al usuario)
			}else {
				//Piso destino mas bajo
				int min = this.getMinFloor();	
				 //distancia del elevador de su piso actual hasta el piso mas abajo + piso mas abajo al piso del usuario
				distance = Math.abs((min - userDirection.getCurrentFloor())) +  Math.abs((min - this.currentFloor));
				return distance; 
			}
		} //el usuario va para abajo
		else {				
			//Si el elevador va para arriba(direccion contraria)
			if(this.direction == Direction.UP) {
				//Piso destino mayor
				int max = this.getMaxFloor();
				//distancia del piso actual al piso maximo + del piso maximo al piso del usuario
				distance = Math.abs((max - userDirection.getCurrentFloor())) + Math.abs((max - this.currentFloor));
				return distance; 
				
			//SI el elevador va para abajo(direccion contraria al usuario)
			}else {.
				
				//Elemento destino mas abajo
				int min = this.getMinFloor();	
				distance = Math.abs((min - userDirection.getCurrentFloor())) + Math.abs((min - this.currentFloor));
				return distance; 
			}
		}
	}	
	
	public int elevatorAboveUser(UserDirection userDirection) {
		
		if(userDirection.getDirection() == Direction.UP) {
			
			//(misma direccion)
			if(this.direction == Direction.UP) {
				//Se busca el ultimo piso al que va el elevador
				int max = this.getMaxFloor();
				//distancia del piso actual al piso maximo + del piso maximo al piso del usuario
				distance = Math.abs((max - userDirection.getCurrentFloor())) + Math.abs((max - this.currentFloor));
				return distance; 
			}
			//direccion contraria 
			else {
				int min = this.getMinFloor();
				//distancia del piso actual al piso minimo + del piso minimo al piso del usuario
				distance = Math.abs((min - userDirection.getCurrentFloor())) + Math.abs((min - this.currentFloor));
				return distance; 
			}
		}
		//El usuario va para abajo
		else {
			if(this.direction == Direction.UP) {
				//Se busca el ultimo piso al que va el elevador
				int max = this.getMaxFloor();
				//distancia del piso actual al piso maximo + del piso maximo al piso del usuario
				distance = Math.abs((max - userDirection.getCurrentFloor())) + Math.abs((max - this.currentFloor));
				return distance; 
			}
			else {
				//distancia del piso actual al piso minimo + del piso minimo al piso del usuario
				distance = Math.abs((this.currentFloor - userDirection.getCurrentFloor()));
				return distance; 
			//direccion contraria
			}
		}		
	}
	
	private int getMaxFloor() {
		int max = this.destinationFloors.get(0);
		for(int floor: this.destinationFloors) {
			if(max < floor)
				max = floor;
		}
		
		return max;
	}
	
	private int getMinFloor() {
		int min = this.destinationFloors.get(0);
		for(int floor: this.destinationFloors) {
			if(min > floor)
				min = floor;
		}
		return min;
	}
			
	


}

