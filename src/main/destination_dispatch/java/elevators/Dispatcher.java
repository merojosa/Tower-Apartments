package elevators;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Dispatcher {
	
	private Hashtable<UserType, List<Integer>> floors;
	private ArrayList<Elevator> elevators;
	private int totalFloors; 
	//estructura con ascensores
	
	public Dispatcher() {
		this.floors = new Hashtable<UserType, List<Integer> >();
		this.elevators = new ArrayList<Elevator>();
	}
	
	public static class Builder{
		private Dispatcher dispatch; 	
		
		public Builder() {
			this.dispatch = new Dispatcher();
		}
		
		public Builder addElevator(Elevator elevator){
			this.dispatch.elevators.add(elevator); 
			return this;
		}
		
		public Builder setNumFloor(int numFloors) {
			this.dispatch.totalFloors = numFloors; 
			return this;
		}
		
		public Builder addFloor(UserType type, int num) {
			List<Integer> previousFloorNumberList = this.dispatch.floors.get(type);
			
			if(previousFloorNumberList == null) {
				previousFloorNumberList = new ArrayList<Integer>();
			}
			
			//Si piso existe
			if(previousFloorNumberList.contains(num)) {
				return this;
			}
			
			previousFloorNumberList.add(num);
			this.dispatch.floors.put(type, previousFloorNumberList);
			return this;
		}
		
		public Dispatcher build() {
			return this.dispatch;
		}
		
	}

	public ArrayList<Elevator> getElevators(){
		return this.elevators; 
	}
	
	public int getTotalFloors() {
		return this.totalFloors;
	}
	
	//para validar
	public boolean isFloorOfType(int floor,UserType floorType) {
		return this.floors.get(floorType).contains(floor);
	}
}
