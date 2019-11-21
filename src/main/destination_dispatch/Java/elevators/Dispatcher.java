package elevators;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Dispatcher {
	
	private Hashtable<UserType, List<Integer>> floors;
	private Arraylist<Elevator> elevators;
	public int totalFloors; 
	//estructura con ascensores
	
	public Dispatch() {
		this.floors = new Hashtable<UserType, List<Integer> >();
	}
	
	public static class Builder{
		private Dispatcher dispatch; 	
		
		public Builder() {
			this.dispatch = new Dispatch(); 
			return this; 			
		}
		
		public Builder addElevator(Elevator elevator){
			this.dispatch.elevators.add(elevator); 
			return this;
		}
		
		public Builder setNumFloor(int numFloors) {
			this.dispatch.totalFloors = numFloors; 
		}
		
		public Builder addFloor(UserType type, int num) {
			List<Integer> previousFloorNumberList = this.dispatch.floors.get(type);
			
			if(floorNumberList == null) {
				previousFloorNumberList = new ArrayList<Integer>();
			}
			
			previousFloorNumberList.add(num);
			this.dispatch.floors.put(type, previousFloorNumberList);
			
		}
		
		public Dispatch build() {
			return this.dispatch;
		}
		
	}
}
