package WB.GenericUtility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * @author SanjayGiri
 */

public class HttpsUtils {


	    public static int getResponseCode(String urlString) {
	        try {
	            // Create a URL object from the urlString
	        	PropertyFileUtility pUtils = new PropertyFileUtility();
	            String baseurl = pUtils.readDataFromPropertyFile("url");
	        	
	        
	            URL url = new URL(baseurl);
	            
	            // Open a connection to the URL
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            
	            // Set the request method to GET
	            connection.setRequestMethod("GET");
	            
	            // Connect to the URL
	            connection.connect();
	            
	            // Get the response code
	            int responseCode = connection.getResponseCode();
	            
	            // Close the connection
	            connection.disconnect();
	            
	            // Return the response code
	            return responseCode;
	        } catch (IOException e) {
	            // Handle any exceptions, such as URL format errors or connection errors
	            e.printStackTrace();
	            
	            // Return -1 if an exception occurs
	            return -1;
	        }
	    }

	   
	}



