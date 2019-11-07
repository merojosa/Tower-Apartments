package management;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import actions.ActionDeviceCommand;

public class MediatorApartment 
{
	private Hashtable<String, List<ActionDeviceCommand>> behaviors;
	
	
	public MediatorApartment()
	{
		behaviors = new Hashtable<String, List<ActionDeviceCommand>>();
	}
	
	
	public void addBehavior(ActionDeviceCommand action, ActionDeviceCommand answer)
	{
		List<ActionDeviceCommand> previousBehaviors = behaviors.get(action.getKey());
		
		if(previousBehaviors == null)
		{
			previousBehaviors = new ArrayList<ActionDeviceCommand>();
		}
			
		previousBehaviors.add(answer);	
		behaviors.put(action.getKey(), previousBehaviors);
	}	
	
	
	public void notifyAction(ActionDeviceCommand action)
	{
		List<ActionDeviceCommand> answersAction = behaviors.get(action.getKey());
		
		if(answersAction != null)
		{
			for(ActionDeviceCommand answer : answersAction)
			{
				answer.execute();
			}
		}
	}
}
