package security;

import java.io.Serializable;
import java.util.ArrayList;

// Nota, se esta violando el patron Single Responsibility.
public class ControlCenter implements Serializable
{
	private LeafCamera camera1;
	private LeafCamera camera2;
	private LeafCamera camera3;
	private LeafCamera camera4;
	private LeafCamera camera5;
	private LeafCamera camera6;
	
	private ArrayList<LeafCamera> allCameras;
	
	//handler del chain of responsibility
	private AutoIdentifier identifier;
	
	private AccesLog log;
	
	private static final long serialVersionUID = 1L;
	private static ControlCenter INSTANCE;
	
	private ControlCenter() 
	{
		camera1 = new LeafCamera(Camera.ON, DirectionCamera.LEFT, LocationCamera.MAINROOM);
		camera2 = new LeafCamera(Camera.ON, DirectionCamera.RIGHT, LocationCamera.MAINROOM);
		camera3 = new LeafCamera(Camera.ON, DirectionCamera.CENTER, LocationCamera.LIVINGROOM);
		camera4 = new LeafCamera(Camera.ON, DirectionCamera.LEFT, LocationCamera.LIVINGROOM);
		camera5 = new LeafCamera(Camera.ON, DirectionCamera.RIGHT, LocationCamera.KITCHEN);
		camera6 = new LeafCamera(Camera.ON, DirectionCamera.CENTER, LocationCamera.KITCHEN);
		
		allCameras = new ArrayList<LeafCamera>();
		allCameras.add(camera1);
		allCameras.add(camera2);
		allCameras.add(camera3);
		allCameras.add(camera4);
		allCameras.add(camera5);
		allCameras.add(camera6);
		
		log = new AccesLog();
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
	
	public void identifyID(String ID)
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
			System.out.println(result);
		else
			System.out.println("No se pudo encontrar al ID en las cámaras\n");
	}
	
	public void addEntranceLog(String ID)
	{
		String result = log.addEntranceLog(ID);
		System.out.println(result);
	}
	
	public void addExitLog(String ID)
	{
		String result = log.addExitLog(ID);
		System.out.println(result);
	}
	
}
