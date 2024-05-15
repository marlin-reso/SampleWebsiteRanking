package WB.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains the property file related methods.
 * @author SanjayGiri
 */
public class PropertyFileUtility {
	
	/**
	 * This method will return the values which inside the property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		try {
		FileInputStream fisp = new FileInputStream(IConstantUtility.propertyFilePath);
		Properties prop = new Properties();
		prop.load(fisp);
		String value = prop.getProperty(key);
		return value;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
