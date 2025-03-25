package websiteRanking.moduleTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WB.GenericUtility.BaseClass;
import WB.GenericUtility.HttpsUtils;
import WB.ObjectRepository.HomePage;
import WB.ObjectRepository.LoginPage;
import WB.ObjectRepository.PreLoginPage;

public class LoginPageTest extends BaseClass{
	
	@Test(priority = 1)
	public void verifyThatAvailableLinksAreNotBrokenOnLoginPageTest() throws IOException
	{
		
		/*
		 * logic: Base class will navigate to you homePage, so in that case you need to
		 * logout to the application which is also navigate to you to the pre-login page
		 * so again click on login button so that you will land on right page.
		 * 
		 * After performing related action you need to login again to application 
		 * otherwise you will get base class exception.
		 */
		// logout from application
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		
		//navigate to login page from pre-login page by clicking on login button
		
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		
		HttpsUtils httpsUtils = new HttpsUtils();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available links "+links);
		int responseCode = 0;
		for(WebElement link:links) {
			String url = link.getDomAttribute("href");
			if(url != null && !url.isEmpty())
			{
			responseCode = httpsUtils.getResponseCode(url);
			
			  if(responseCode == HttpURLConnection.HTTP_OK)
			  {
			  System.out.println("Link " + url + " is not broken");
			  }
			  else {
				  System.out.println("Link "+ url + " is broken (Http respnse code: "+ responseCode+")");
			  }
			} 
		}
		
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
	}

	@Test (priority = 2)
	public void verifyThatLoginPageIsDisplayedTest() throws IOException
	{
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.logoutAction();
		
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		
		String expectedTitle = "Login | Website Ranking";
		String actualTitle = driver.getTitle();
		System.out.println("Actual title " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Login page title mismatch");	
		
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");

		lp.loginToApplication(USERNAME, PASSWORD);
		
	}
	
	
	@Test(priority = 3)
	public void verifyThatAllTheTextFieldsAreEnabledTest() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		
		LoginPage lp = new LoginPage(driver);
		
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		
		if(lp.getEmailTxtField().isEnabled())
		{
			Assert.assertTrue(true, "Login page's email text field is enabled");
		}
		else {
			Assert.assertFalse(true, "Login page's email text field is disabled");
		}
		
		if(lp.getPasswordTxtField().isEnabled())
		{
			Assert.assertTrue(true, "Login Page's password text field is enabled");
		}
		else {
			Assert.assertFalse(true, "Login page's password text field is disabled");
		}	
			
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
	system.out.println(PASSWORD);
		lp.loginToApplication(USERNAME, PASSWORD);
	}
	
	@Test (priority = 4)
	public void verifyThatAllTheButtonsAreEnabledTest() throws IOException
	{
		
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
	
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		LoginPage lp = new LoginPage(driver);
		
		if(lp.getSubmitBtn().isEnabled())
		{
			Assert.assertTrue(true, "Submit button is enabled");
		}
		else {
			Assert.assertFalse(true, "Submit button is disabled");
		}
		
		if(lp.getRegisterHereLink().isEnabled())
		{
			Assert.assertTrue(true, "Register link is enabled");
		}else {
			Assert.assertFalse(true, "Register link is disabled");
		}
		
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		
		wUtils.waitForElementToBeClickable(driver, lp.getSubmitBtn());
	
		lp.loginToApplication(USERNAME, PASSWORD);
	
	}
	

}
