package cameras_management;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AccesLog {
	private ArrayList<String> log;
	
	public AccesLog()
	{
		log = new ArrayList<String>();
	}
	
	public String addEntranceLog(String ID)
	{
		Date date = new Date();
		SimpleDateFormat format =
		new SimpleDateFormat ("E yyyy.MM.dd 'a las' hh:mm:ss a");
		String newLog = "El ID: " + ID + " ingresó al complejo de apartamentos el día " + format.format(date);
		log.add(newLog);
		return newLog;
	}
	
	public String addExitLog(String ID)
	{
		Date date = new Date();
		SimpleDateFormat format =
		new SimpleDateFormat ("E yyyy.MM.dd 'a las' hh:mm:ss a");
		String newLog = "El ID: " + ID + " salió del complejo de apartamentos el día " + format.format(date);
		log.add(newLog);
		return newLog;
	}
	
	public ArrayList<String> getLog()
	{
		return log;
	}
}
