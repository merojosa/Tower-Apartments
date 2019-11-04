package actuators_sensors;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Mediator 
{
	// Necesito definir que devuelvo de acuerdo a la llave.
	private Hashtable<String, List<Object>> behaviors;
	
	
	public Mediator()
	{
		behaviors = new Hashtable<String, List<Object>>();
	}
	
	
	public void addBehavior(String keyDevice, Object action)
	{
		List<Object> previousBehaviors = behaviors.get(keyDevice);
		
		if(previousBehaviors == null)
		{
			previousBehaviors = new ArrayList<Object>();
		}
			
		previousBehaviors.add(action);	
		behaviors.put(keyDevice, previousBehaviors);
	}	
	
	
	public void getNotification(String keyDevice)
	{
		Object action = behaviors.get(keyDevice);
		
		// If there was an action established.
		if(action != null)
		{
			
		}
	}
}
