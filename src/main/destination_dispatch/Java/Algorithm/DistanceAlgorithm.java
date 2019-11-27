
public class DistanceAlgorithm implements DispatcherAlgorithm{
	
	public int requestElevator(UserDirection user, Usertype type, Dispatcher dispatch) {
		
		Arraylist<Elevator> elevators = dispatch.getElevators();
		int elevatorId = 0;
		Elevator elevator1 = null; 
		
		for(Elevator elevator: elevators) { 
			//Si el elevador es del mismo tipo del usuario 
			if(elevator.getType() == userType){
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
