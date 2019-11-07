package cameras_management;

import java.io.Serializable;
import java.util.ArrayList;

// Nota, se esta violando el patron Single Responsibility.
public class ControlCenter implements Serializable
{
	private int FIRST_FLOOR_CAMERAS_INDEX = 0;
	private int SECOND_FLOOR_CAMERAS_INDEX = 0;
	private static int MIN_ARRAY_SIZE = 6;
	
	private LeafCamera camera1;
	private LeafCamera camera2;
	private LeafCamera camera3;
	private LeafCamera camera4;
	private LeafCamera camera5;
	private LeafCamera camera6;
	
	private ArrayList<LeafCamera> allCameras;
	private ArrayList<ComponentCamera> groupedCameras;
	
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
	
	public void makeFirstFloorCamerasComposite()
	{
		ComponentCamera firstFloorCameras = new CompositeCamera.Builder().addCamera(camera1).addCamera(camera3).addCamera(camera5).build();
		groupedCameras.add(firstFloorCameras);
		FIRST_FLOOR_CAMERAS_INDEX = groupedCameras.indexOf(firstFloorCameras);
	}
	
	public void makeSecondFloorCamerasComposite()
	{
		ComponentCamera secondFloorCameras = new CompositeCamera.Builder().addCamera(camera2).addCamera(camera4).addCamera(camera6).build();
		groupedCameras.add(secondFloorCameras);
		SECOND_FLOOR_CAMERAS_INDEX = groupedCameras.indexOf(secondFloorCameras);
	}
	
	public void changeFirstFloorCamerasDirection(DirectionCamera direction)
	{
		groupedCameras.get(FIRST_FLOOR_CAMERAS_INDEX).setDirection(direction);
	}
	
	public void changeSecondFloorCamerasDirection(DirectionCamera direction)
	{
		groupedCameras.get(SECOND_FLOOR_CAMERAS_INDEX).setDirection(direction);
	}
	
	public void showCamerasStatus()
	{
		String result = "";
		for (int index = 0; index < allCameras.size(); index++)
		{
			result = result + "Camara numero " + index + " se encuentra en " + allCameras.get(index).getProperties().getLocation() 
							+ " y se encuentra viendo hacia " + allCameras.get(index).getProperties().getDirection() + "\n";
		}
		System.out.println(result);
	}
	
	//estos métodos son sólo para hacer tests------------------------
	public void addID(int cameraIndex, String ID)
	{
		allCameras.get(cameraIndex).getProperties().addID(ID);
	}
	
	public ComponentCamera getCameraGroup(int index)
	{
		return groupedCameras.get(index);
	}
	//---------------------------------------------------------------
}
