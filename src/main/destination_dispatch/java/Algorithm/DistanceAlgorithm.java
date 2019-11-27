package Algorithm;
import java.util.ArrayList;
import elevators.*;

public class DistanceAlgorithm implements DispatcherAlgorithm{
	
	public int requestElevator(UserDirection user, UserType type, Dispatcher dispatch) {
		
		ArrayList<Elevator> elevators = dispatch.getElevators();
		Elevator elevator1 = null; 
		
		//Validar si usuario tiene acceso a piso
		if(type == UserType.NORMAL && dispatch.isFloorOfType(user.getDestinationFloor(), UserType.PREMIUM)) {
			return -1;
		}
		
		for(Elevator elevator: elevators) { 
			//Si el elevador es del mismo tipo del usuario 
			if(elevator.getType() == type){
				if(elevator1 == null)
					elevator1 = elevator; 
				else {
					if(elevator1.getArrivalTime(user) > elevator.getArrivalTime(user)) {
						elevator1 = elevator;
					}
				}
			}
		}
		
		return elevator1.getID(); 
	}	
}	
