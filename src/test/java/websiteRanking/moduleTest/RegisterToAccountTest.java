package websiteRanking.moduleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import WB.GenericUtility.BaseClass;
import WB.ObjectRepository.LoginPage;
import WB.ObjectRepository.PreLoginPage;
import WB.ObjectRepository.RegisterConfirmationPage;
import WB.ObjectRepository.RegisterPage;

public class RegisterToAccountTest extends BaseClass{
	
	@Test(priority = 2)
	public void registerToAccountTestViaLoginPage() throws EncryptedDocumentException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.clickOnRegisterHereLink(driver);
		
		RegisterPage rp = new RegisterPage(driver);
		rp.signupToYourAccount();
		
		RegisterConfirmationPage rcp = new RegisterConfirmationPage(driver);
		rcp.clickOnContinueAsNewUser();
			
		
	}
	@Test(priority = 1)
	public void loginToApplicationFromRegistrationPage() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.clickOnRegisterHereLink(driver);
		
		RegisterPage rp = new RegisterPage(driver);
		rp.clickOnLoginHereLink();
		
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		
		lp.loginToApplication(USERNAME, PASSWORD);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
