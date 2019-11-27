package Algorithm;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import elevators.*;

public class TimeAlgorithmStrategy implements DispatcherAlgorithmStrategy{
	
	private ArrayList<Elevator> elevators;
	
	public int requestElevator(UserDirection user, UserType type) {
		
		Elevator elevator = null; 
		
		for(Elevator e: elevators) { 
			//Si el elevador es del mismo tipo del usuario 
			if(e.getType() == type){
				if(elevator == null)
					elevator = e; 
				else {
					if(elevator.getArrivalTime(user) > e.getArrivalTime(user)) {
						elevator = e;
					}
				}
			}
		}
		
		return elevator.getID(); 
	}	
	
	public void setScenario(ArrayList<Elevator> elevatorList) {
		this.elevators = elevatorList;
	}
}	
