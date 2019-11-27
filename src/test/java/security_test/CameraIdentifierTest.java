package security_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cameras_management.AutoIdentifier;
import cameras_management.Camera;
import cameras_management.CameraIdentifier;
import cameras_management.CameraOn;
import cameras_management.LocationCamera;

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
		
		camera1 = new CameraOn();
		camera2 = new CameraOn();
		camera3 = new CameraOn();
		camera4 = new CameraOn();
		
		camera3.getProperties().addID("117560704");
		camera3.getProperties().setLocation(LocationCamera.MAINROOM);
		
		camaras.add(camera1);
		camaras.add(camera2);
		camaras.add(camera3);
		camaras.add(camera4);
	}
}
