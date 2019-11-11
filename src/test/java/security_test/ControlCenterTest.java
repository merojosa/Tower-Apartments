package security_test;

import org.junit.Assert;
import org.junit.Test;

import cameras_management.ComponentCamera;
import cameras_management.ControlCenter;
import cameras_management.DirectionCamera;

public class ControlCenterTest 
{

	@Test
	public void identifierTest() 
	{
		String ID = "117560704";
		ControlCenter controler = ControlCenter.getControlCenter();
		controler.addID(3, ID);
		boolean result = controler.identifyID(ID);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void cameraControlTest()
	{
		ControlCenter controler = ControlCenter.getControlCenter();
		controler.makeFirstFloorCamerasComposite();
		controler.showCamerasStatus();
		controler.changeFirstFloorCamerasDirection(DirectionCamera.RIGHT);
		for (ComponentCamera camera: controler.getCameraGroup(0).getSetCamera())
		{
			Assert.assertSame(camera.getDirection(), DirectionCamera.RIGHT);
		}
		controler.showCamerasStatus();
	}

}
