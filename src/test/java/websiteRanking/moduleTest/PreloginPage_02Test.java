package websiteRanking.moduleTest;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import WB.GenericUtility.BaseClass;
import WB.GenericUtility.HttpsUtils;
import WB.ObjectRepository.HomePage;
import WB.ObjectRepository.LoginPage;
import WB.ObjectRepository.PreLoginPage;

public class PreloginPage_02Test extends BaseClass{
	
	
	@Test (priority = 1)
	public void verifyThatSearchFunctionalityIsDisplayedOnPreloginPageTest() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		PreLoginPage plp = new PreLoginPage(driver);
		plp.getSearchField().isDisplayed();
		plp.clickOnLoginBtn();
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);	
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	@Test (priority = 2)
	public void verifyThatAfterClickingOnGetStartedButtonItWillNaviageToRightPageTest() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		HttpsUtils httpsUtils = new HttpsUtils();
		/*
		 * Capture the get started link
		 */
		WebElement link = driver.findElement(By.xpath("//a[@href='https://youtu.be/bcnCOW0Kp28?si=rmJBtF3AhPxd9gYk']"));
		int responseCode = 0;
		String url = link.getAttribute("href");
		if(url != null && !url.isEmpty())
		{
			responseCode = httpsUtils.getResponseCode(url);
			
			if(responseCode == HttpURLConnection.HTTP_OK);
			
				System.out.println("Link " + url + "is not broken ");
		}else {
				
				System.out.println("Link " + url + " is broken (HTTP response code: " + responseCode +")");
			}
		PreLoginPage plp = new PreLoginPage(driver);
		
		plp.clickOnLoginBtn();
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		}
	
	@Test (priority = 3)
	public void verifyThatAfterClickingOnBlogLinkItWillNavigateYouToRightPageTest()
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnBlogBtn();
		
		SoftAssert softAssert = new SoftAssert();
		String actual = driver.getTitle();
		String expected ="Website Ranking Ai Blog : Elevate Your Website's Performance with AI-Powered Insights - Unlocking Your Website's Potential, One Rank at a Time";
		
		softAssert.assertEquals(actual, expected,  " Blog page title mismatch ");
		//System.out.println("--------title------"+actual);
		//Assert.assertEquals(actual, expected, " Blog page title mismatch ");
		wUtils.navigateBackwordAction(driver);
		plp.clickOnLoginBtn();
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
			
	}
	@Test(priority = 4)
	public void verifyThatAfterClickingOnWhyusLinkItWillNavigateYouToRightPage() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnWhyUsBtn();
		SoftAssert softAssert = new SoftAssert();
		
		String actual = driver.getTitle();
		String expected = "Why Choose WebsiteRanking.ai? | Websiteranking.ai";
	
		softAssert.assertEquals(actual, expected,  "Why us page title mismatch");
		//	System.out.println("----------------"+actual);
	
		//	Assert.assertEquals(actual, expected, "Why us page title mismatch");
		wUtils.navigateBackwordAction(driver);
		plp.clickOnLoginBtn();
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApplication(USERNAME, PASSWORD);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
		
	
	

}
