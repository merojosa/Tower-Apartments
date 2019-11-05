package actuators_sensors;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Mediator 
{
	// Necesito definir que devuelvo de acuerdo a la llave.
	private Hashtable<String, List<ActionDevice>> behaviors;
	
	
	public Mediator()
	{
		behaviors = new Hashtable<String, List<ActionDevice>>();
	}
	
	
	public void addBehavior(String keyDevice, ActionDevice action)
	{
		List<ActionDevice> previousBehaviors = behaviors.get(keyDevice);
		
		if(previousBehaviors == null)
		{
			previousBehaviors = new ArrayList<ActionDevice>();
		}
			
		previousBehaviors.add(action);	
		behaviors.put(keyDevice, previousBehaviors);
	}	
	
	
	public void getNotification(String keyDevice)
	{
		List<ActionDevice> listActions = behaviors.get(keyDevice);
		
		if(listActions != null)
		{
			for(ActionDevice action : listActions)
			{
				action.execute();
			}
		}
	}
}
