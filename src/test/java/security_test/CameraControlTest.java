package security_test;

import org.junit.Assert;
import org.junit.Test;

import security.ComponentCamera;
import security.LeafCamera;
import security.CompositeCamera;
import security.DirectionCamera;
import security.StateCamera;

public class CameraControlTest 
{

	@Test
	public void changeDirectionCameraOnTest() 
	{
		ComponentCamera camera = new LeafCamera(StateCamera.ON, DirectionCamera.LEFT);
		camera.setDirection(DirectionCamera.RIGHT);
		Assert.assertSame(DirectionCamera.RIGHT, ((LeafCamera) camera).getState().getDirection());
	}
	
	
	@Test
	public void changeDirectionCameraOffTest() 
	{
		ComponentCamera camera = new LeafCamera(StateCamera.OFF);
		camera.setDirection(DirectionCamera.LEFT);
		Assert.assertNotSame(DirectionCamera.LEFT, ((LeafCamera) camera).getState().getDirection());
	}
	
	
	@Test
	public void changeDirectionCompositeTest()
	{
		ComponentCamera composite_test = new CompositeCamera.Builder()
								.addCamera(new LeafCamera(StateCamera.ON, DirectionCamera.CENTER))
								.addCamera(new LeafCamera(StateCamera.ON, DirectionCamera.LEFT))
								.addCamera(new LeafCamera(StateCamera.ON, DirectionCamera.RIGHT))
								.addCamera(new LeafCamera(StateCamera.ON, DirectionCamera.CENTER))
								.addCamera(new LeafCamera(StateCamera.ON, DirectionCamera.LEFT))
								.build();
		
		composite_test.setDirection(DirectionCamera.RIGHT);
		
		for(ComponentCamera camera : ((CompositeCamera) composite_test).getCameras())
		{
			Assert.assertSame(((LeafCamera) camera).getState().getDirection(), DirectionCamera.RIGHT);
		}
	}

}
