package WB.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * @author SanjayGiri
 */
public class JavaUtility {
	
	
	/**
	 * This method will return the system date.
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
			
	}
	
	
	/**
	 * This method will provide system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String date[] = d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = date1+""+month+""+year+""+time;
		return finalDate;
			
	}
	
	/**
	 * This method will provide random number.
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(8999)+1000;
		return random;
		
	}

}
