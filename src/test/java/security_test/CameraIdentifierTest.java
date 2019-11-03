package security_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import security.AutoIdentifier;
import security.Camera;
import security.CameraIdentifier;
import security.LocationCamera;

import java.util.ArrayList;
import java.util.List;

public class CameraIdentifierTest {
	private List<Camera> camaras;
	
	private Camera camera1;
	private Camera camera2;
	private Camera camera3;
	private Camera camera4;
	
	private AutoIdentifier identifier;
	
	@Before
	public void init()
	{
		camaras = new ArrayList<Camera>();
		identifier = new CameraIdentifier();
		
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
	
	@Test
	public void cameraIdentifierTest()
	{
		String result = "";
		String ID = "117560704";
		String expected = "La cámara en MAINROOM identificó al ID: 117560704";
		
		for (Camera camara: camaras)
		{
			if(identifier.canIdentify(camara, ID))
			{
				result = identifier.identify(camara, ID);
			}
		}
		Assert.assertEquals(expected, result);
	}
}
