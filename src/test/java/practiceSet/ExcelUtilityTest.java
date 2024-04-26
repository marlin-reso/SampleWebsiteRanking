package practiceSet;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import WB.GenericUtility.ExcelFileUtility;

public class ExcelUtilityTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
			ExcelFileUtility eUtils = new ExcelFileUtility();
			String name = eUtils.readDataFromExcelFile("signupPage", 1, 0);
			System.out.println("name "+name);
			
			String phoneNo = eUtils.readDataFromExcelFile("signupPage",1, 1);
			System.out.println("phone number "+phoneNo);
			
			
			String email = eUtils.readDataFromExcelFile("signupPage", 1, 2);
			System.out.println( "email "+email);
			String websiteDomain = eUtils.readDataFromExcelFile("signupPage", 1, 3);
			System.out.println("websiteDomail "+websiteDomain);
			
			String createPassword = eUtils.readDataFromExcelFile("signupPage", 1, 4);
			System.out.println("createPassword "+createPassword);
			
			String confirmPassword = eUtils.readDataFromExcelFile("signupPage", 1, 5);
			System.out.println("confirmPassword"+confirmPassword);
			
		
	}

}
