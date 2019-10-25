package security_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import security.Camera;
import security.CameraImplementation;
import security.CompositeCamera;
import security.DirectionCamera;
import security.StateCamera;

public class CameraControlTest {

	@Test
	public void changeDirectionCameraOnTest() 
	{
		Camera camera = new CameraImplementation(StateCamera.ON);
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
		List<Camera> cameras = new ArrayList<Camera>();
		
		cameras.add(new CameraImplementation(StateCamera.ON));
		cameras.add(new CameraImplementation(StateCamera.ON));
		cameras.add(new CameraImplementation(StateCamera.ON));
		cameras.add(new CameraImplementation(StateCamera.ON));
		cameras.get(0).setDirection(DirectionCamera.LEFT);
		
		Camera composite = new CompositeCamera(cameras);
		composite.setDirection(DirectionCamera.RIGHT);
		
		for(Camera camera : cameras)
		{
			Assert.assertSame(((CameraImplementation) camera).getState().getDirection(), DirectionCamera.RIGHT);
		}
		
	}

}
