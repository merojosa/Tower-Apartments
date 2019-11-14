package security_test;

import org.junit.Assert;
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
	ControlCenter controler = ControlCenter.getControlCenter();
	
	LeafCamera camera1 = new LeafCamera(new CameraOn(), DirectionCamera.LEFT, LocationCamera.MAINROOM);
	LeafCamera camera2 = new LeafCamera(new CameraOn(), DirectionCamera.RIGHT, LocationCamera.MAINROOM);
	LeafCamera camera3 = new LeafCamera(new CameraOn(), DirectionCamera.CENTER, LocationCamera.LIVINGROOM);
	LeafCamera camera4 = new LeafCamera(new CameraOn(), DirectionCamera.LEFT, LocationCamera.LIVINGROOM);
	LeafCamera camera5 = new LeafCamera(new CameraOn(), DirectionCamera.RIGHT, LocationCamera.KITCHEN);
	LeafCamera camera6 = new LeafCamera(new CameraOn(), DirectionCamera.CENTER, LocationCamera.KITCHEN);
	

	@Test
	public void identifierTest() 
	{
		controler.addCamera(camera1);
		controler.addCamera(camera2);
		controler.addCamera(camera3);
		controler.addCamera(camera4);
		controler.addCamera(camera5);
		controler.addCamera(camera6);
		
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
