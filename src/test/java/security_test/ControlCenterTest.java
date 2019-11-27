package security_test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cameras_management.CameraOn;
import cameras_management.ComponentCamera;
import cameras_management.CompositeCamera;
import cameras_management.ControlCenter;
import cameras_management.DirectionCamera;
import cameras_management.LeafCamera;
import cameras_management.LocationCamera;

public class ControlCenterTest 
{
	ControlCenter controler;
	
	LeafCamera camera1;
	LeafCamera camera2;
	LeafCamera camera3;
	LeafCamera camera4;
	LeafCamera camera5;
	LeafCamera camera6;
	
	@Before
	public void init()
	{
		camera1 = new LeafCamera(new CameraOn(), DirectionCamera.LEFT, LocationCamera.MAINROOM);
		camera2 = new LeafCamera(new CameraOn(), DirectionCamera.RIGHT, LocationCamera.MAINROOM);
		camera3 = new LeafCamera(new CameraOn(), DirectionCamera.CENTER, LocationCamera.LIVINGROOM);
		camera4 = new LeafCamera(new CameraOn(), DirectionCamera.LEFT, LocationCamera.LIVINGROOM);
		camera5 = new LeafCamera(new CameraOn(), DirectionCamera.RIGHT, LocationCamera.KITCHEN);
		camera6 = new LeafCamera(new CameraOn(), DirectionCamera.CENTER, LocationCamera.KITCHEN);
		
		controler = ControlCenter.getControlCenter();
		
		// init is called every test method, so that, if there is no clear, controller will have more than 6 cameras.
		// After all, it's a singleton.
		controler.getAllCameras().clear();
		
		controler.addCamera(camera1);
		controler.addCamera(camera2);
		controler.addCamera(camera3);
		controler.addCamera(camera4);
		controler.addCamera(camera5);
		controler.addCamera(camera6);
	}
	
	@Test
	public void accessLogTest()
	{
		String result1 = controler.addEntranceLog("117560704");
		String result2 = controler.addExitLog("117560704");
		
		ArrayList<String> testArray = controler.getAccessLog().getLog();
		Assert.assertSame(result1, testArray.get(0));
		Assert.assertSame(result2, testArray.get(1));
	}
	
	@Test
	public void identifierTest() 
	{		
		String ID = "117560704";
		controler.addID(3, ID);
		boolean result = controler.identifyID(ID);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void cameraControlTest()
	{
		ComponentCamera composite_test = new CompositeCamera.Builder()
										.addCamera(camera1)
										.addCamera(camera3)
										.addCamera(camera5)
										.build();
		
		controler.addComposite(composite_test);
		controler.showCamerasStatus();
		controler.changeCamerasDirection(0,DirectionCamera.RIGHT);
		for (ComponentCamera camera: controler.getCameraGroup(0).getSetCamera())
		{
			Assert.assertSame(camera.getDirection(), DirectionCamera.RIGHT);
		}
		controler.showCamerasStatus();
	}

}
