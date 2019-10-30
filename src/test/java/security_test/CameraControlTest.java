package security_test;

import org.junit.Assert;
import org.junit.Test;

import security.ComponentCamera;
import security.LeafCamera;
import security.CompositeCamera;
import security.DirectionCamera;
import security.Camera;

public class CameraControlTest 
{

	@Test
	public void changeDirectionCameraOnTest() 
	{
		ComponentCamera camera = new LeafCamera(Camera.ON, DirectionCamera.LEFT);
		camera.setDirection(DirectionCamera.RIGHT);
		Assert.assertSame(DirectionCamera.RIGHT, camera.getProperties().getDirection());
	}
	
	
	@Test
	public void changeDirectionCameraOffTest() 
	{
		ComponentCamera camera = new LeafCamera(Camera.OFF);
		camera.setDirection(DirectionCamera.LEFT);
		Assert.assertNotSame(DirectionCamera.LEFT, camera.getProperties().getDirection());
	}
	
	
	@Test
	public void changeDirectionCompositeTest()
	{
		ComponentCamera composite_test = new CompositeCamera.Builder()
								.addCamera(new LeafCamera(Camera.ON, DirectionCamera.CENTER))
								.addCamera(new LeafCamera(Camera.ON, DirectionCamera.LEFT))
								.addCamera(new LeafCamera(Camera.ON, DirectionCamera.RIGHT))
								.addCamera(new LeafCamera(Camera.ON, DirectionCamera.CENTER))
								.addCamera(new LeafCamera(Camera.ON, DirectionCamera.LEFT))
								.build();
		
		composite_test.setDirection(DirectionCamera.RIGHT);
		
		for(ComponentCamera camera : composite_test.getSetCamera())
		{
			Assert.assertSame(camera.getProperties().getDirection(), DirectionCamera.RIGHT);
		}
	}
}
