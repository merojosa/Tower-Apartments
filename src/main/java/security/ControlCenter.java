package security;

import java.io.Serializable;

// Nota, se esta violando el patron Single Responsibility.
public class ControlCenter implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static ControlCenter INSTANCE;
	
	private ControlCenter() {}
	
	public synchronized static ControlCenter getControlCenter()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new ControlCenter();
		}
		return INSTANCE;
	}
	
	private Object readResolve() 
	{
        return INSTANCE;
	}
}
