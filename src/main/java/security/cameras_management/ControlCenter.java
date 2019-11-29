package cameras_management;

import java.io.Serializable;
import java.util.ArrayList;

// Nota, se esta violando el patron Single Responsibility.
public class ControlCenter implements Serializable
{
	private ArrayList<LeafCamera> allCameras;
	private ArrayList<ComponentCamera> groupedCameras;
	
	//handler del chain of responsibility
	private AutoIdentifier identifier;
	
	private AccessLog log;
	
	private static final long serialVersionUID = 1L;
	private static ControlCenter INSTANCE;
	
	private ControlCenter() 
	{
		allCameras = new ArrayList<LeafCamera>();
		
		log = new AccessLog();
		
		groupedCameras = new ArrayList<ComponentCamera>();
		
		identifier = new CameraIdentifier();
	}
	
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
	
	public boolean identifyID(String ID)
	{
		boolean foundID = false;
		String result = "";
		for (LeafCamera camera: allCameras)
		{
			if(identifier.canIdentify(camera.getCamera(), ID))
			{
				result = identifier.identify(camera.getCamera(), ID);
				foundID = true;
			}
		}
		
		if (foundID == true)
		{
			System.out.println(result);
			return foundID;
		}
		else
		{
			System.out.println("No se pudo encontrar al ID en las camaras");
			return foundID;
		}
			
	}
	
	public String addEntranceLog(String ID)
	{
		String result = log.addEntranceLog(ID);
		System.out.println(result);
		return result;
	}
	
	public String addExitLog(String ID)
	{
		String result = log.addExitLog(ID);
		System.out.println(result);
		return result;
	}
	
	public AccessLog getAccessLog()
	{
		return log;
	}
	
	public void addCamera(LeafCamera camera)
	{
		allCameras.add(camera);
	}
	
	public void addComposite(ComponentCamera component)
	{
		groupedCameras.add(component);
	}
	
	public void changeCamerasDirection(int compositeIndex, DirectionCamera direction)
	{
		groupedCameras.get(compositeIndex).setDirection(direction);
	}

	public void showCamerasStatus()
	{
		String result = "";
		for (int index = 0; index < allCameras.size(); index++)
		{
			result = result + "Camara numero " + (index + 1) + " se encuentra en " + allCameras.get(index).getCamera().getProperties().getLocation() 
							+ " y se encuentra viendo hacia " + allCameras.get(index).getCamera().getProperties().getDirection() + "\n";
		}
		System.out.println(result);
	}
	
	//estos metodos son solo para hacer tests------------------------
	public void addID(int cameraIndex, String ID)
	{
		allCameras.get(cameraIndex).getCamera().getProperties().addID(ID);
	}
	
	public ComponentCamera getCameraGroup(int index)
	{
		return groupedCameras.get(index);
	}
	//---------------------------------------------------------------
	
	public ArrayList<LeafCamera> getAllCameras()
	{
		return allCameras;
	}
}
