package security_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import security.Camera;
import security.LocationCamera;

import java.util.List;

public class CameraIdentifierTest {
	private List<Camera> camaras;
	
	private Camera camera1;
	private Camera camera2;
	private Camera camera3;
	private Camera camera4;
	
	@Before
	public void init()
	{
		camera1 = Camera.ON;
		camera2 = Camera.ON;
		camera3 = Camera.ON;
		camera4 = Camera.ON;
		
		camera3.getProperties().addID("117560704");
		camera3.getProperties().setLocation(LocationCamera.MAINROOM);
		
		camaras.add(camera1);
		camaras.add(camera2);
		camaras.add(camera3);
		camaras.add(camera4);
	}
	
}
