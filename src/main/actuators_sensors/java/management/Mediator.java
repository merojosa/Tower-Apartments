package management;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import actions.ActionDeviceStrategy;

public class Mediator 
{
	private Hashtable<String, List<ActionDeviceStrategy>> behaviors;
	
	
	public Mediator()
	{
		behaviors = new Hashtable<String, List<ActionDeviceStrategy>>();
	}
	
	
	public void addBehavior(ActionDeviceStrategy action, ActionDeviceStrategy answer)
	{
		List<ActionDeviceStrategy> previousBehaviors = behaviors.get(action.getKey());
		
		if(previousBehaviors == null)
		{
			previousBehaviors = new ArrayList<ActionDeviceStrategy>();
		}
			
		previousBehaviors.add(answer);	
		behaviors.put(action.getKey(), previousBehaviors);
	}	
	
	
	public void notifyAction(ActionDeviceStrategy action)
	{
		List<ActionDeviceStrategy> answersAction = behaviors.get(action.getKey());
		
		if(answersAction != null)
		{
			for(ActionDeviceStrategy answer : answersAction)
			{
				answer.execute();
			}
		}
	}
}
