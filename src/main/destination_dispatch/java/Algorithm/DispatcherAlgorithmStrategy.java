package Algorithm;

import java.util.ArrayList;

import elevators.*;

public interface DispatcherAlgorithmStrategy {
	public int requestElevator(UserDirection user, UserType type); 
	
	public void setScenario(ArrayList<Elevator> elevators);
}
