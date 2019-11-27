package Algorithm;

import elevators.*;

public interface DispatcherAlgorithm {
	public int requestElevator(UserDirection user, UserType type, Dispatcher dispatch); 
}
