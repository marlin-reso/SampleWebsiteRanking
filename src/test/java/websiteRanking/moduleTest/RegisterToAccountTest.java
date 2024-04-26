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
	
	@Test()
	public void registerToAccountTestViaLoginPageTest() throws EncryptedDocumentException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.clickOnRegisterHereLink(driver);
		
		RegisterPage rp = new RegisterPage(driver);
		rp.signupToYourAccount();
		
		RegisterConfirmationPage rcp = new RegisterConfirmationPage(driver);
		rcp.clickOnContinueAsNewUser();
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
