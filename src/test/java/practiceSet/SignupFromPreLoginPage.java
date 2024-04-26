package practiceSet;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import WB.GenericUtility.BaseClass;
import WB.ObjectRepository.PreLoginPage;
import WB.ObjectRepository.RegisterConfirmationPage;
import WB.ObjectRepository.RegisterPage;

public class SignupFromPreLoginPage extends BaseClass{
	
	@Test()
	public void registerToAccountTestViaSignupButton() throws EncryptedDocumentException, IOException
	{
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnSignupBtn();
		
		System.out.println("clicking on sign up button");
		
		RegisterPage rp = new RegisterPage(driver);
		rp.signupToYourAccount();
		
		RegisterConfirmationPage rcp = new RegisterConfirmationPage(driver);
		rcp.clickOnContinueAsNewUser();
			
		
	}
	
	

}
