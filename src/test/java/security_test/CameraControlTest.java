package security_test;

import org.junit.Assert;
import org.junit.Test;

import security.Camera;
import security.CameraImplementation;
import security.CompositeCamera;
import security.DirectionCamera;
import security.StateCamera;

public class CameraControlTest 
{

	@Test
	public void changeDirectionCameraOnTest() 
	{
		Camera camera = new CameraImplementation(StateCamera.ON, DirectionCamera.LEFT);
		camera.setDirection(DirectionCamera.RIGHT);
		Assert.assertSame(DirectionCamera.RIGHT, ((CameraImplementation) camera).getState().getDirection());
	}
	
	
	@Test
	public void changeDirectionCameraOffTest() 
	{
		Camera camera = new CameraImplementation(StateCamera.OFF);
		camera.setDirection(DirectionCamera.LEFT);
		Assert.assertNotSame(DirectionCamera.LEFT, ((CameraImplementation) camera).getState().getDirection());
	}
	
	
	@Test
	public void changeDirectionCompositeTest()
	{
		Camera composite_test = new CompositeCamera.Builder()
								.addCamera(new CameraImplementation(StateCamera.ON, DirectionCamera.CENTER))
								.addCamera(new CameraImplementation(StateCamera.ON, DirectionCamera.LEFT))
								.addCamera(new CameraImplementation(StateCamera.ON, DirectionCamera.RIGHT))
								.addCamera(new CameraImplementation(StateCamera.ON, DirectionCamera.CENTER))
								.addCamera(new CameraImplementation(StateCamera.ON, DirectionCamera.LEFT))
								.build();
		
		composite_test.setDirection(DirectionCamera.RIGHT);
		
		for(Camera camera : ((CompositeCamera) composite_test).getCameras())
		{
			Assert.assertSame(((CameraImplementation) camera).getState().getDirection(), DirectionCamera.RIGHT);
		}
	}

}
