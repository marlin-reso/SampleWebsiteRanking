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

public class PreloginPageTest extends BaseClass {
	
	@Test(priority = 1)
	public void verifyThatPreloginPageIsDisplayedAfterLogoutTest()
	{
		try {	
		HomePage hp = new HomePage(driver);
		hp.logoutAction();	
		String actual = driver.getTitle();
	//	System.out.println("Actual Page title is "+actual);
		String expected = "Website Ranking: Website Health Analysis & Monitoring ToolKit";
		Assert.assertEquals(actual, expected, "Pre-login page title mismatch");
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void verifyThatAfterClickingOnWebsitesTop100ButtonItWillNaviageToRightPageTest() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnTop100Btn();
		String actual = driver.getTitle();
		String expected = "Top 100 Websites Ranking - Most Visited Websites in March 2024 | Websiteranking.ai";
		System.out.println("Actual Title "+actual);
		Assert.assertEquals(actual, expected, "Website Top 100 page title mismatch");
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
	@Test(priority = 3)
	public void verifyThatAvailableLinksAreNotBrokenOnPreloginPageTest() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		
		HttpsUtils httpsUtils = new HttpsUtils();
		/*
		 * capture all the available links from pre-login page.
		 */
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
	//	System.out.println("available links ****"+links);
		
		int responseCode=0;
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			if(url != null && !url.isEmpty())
			{
				responseCode = httpsUtils.getResponseCode(url);
				
				if(responseCode == HttpURLConnection.HTTP_OK)
				{
					System.out.println("Link "+ url + " is not brokent");
				}else {
					
					System.out.println("Link " + url + " is brokent (HTTP response code: "+ responseCode +")");
					
				}
			}
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
	
	@Test(priority = 4)
	public void verifyThatSearchFunctionalityIsEnabledOnPreloginPageTest() throws IOException
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		
		PreLoginPage plp = new PreLoginPage(driver);
		plp.getSearchField().isEnabled();
		
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
	@Test (priority = 5)
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
	
	@Test (priority = 6)
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
	
	@Test (priority = 7)
	public void verifyThatAfterClickingOnBlogLinkItWillNavigateYouToRightPageTest()
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnBlogBtn();
		String actual = driver.getTitle();
		String expected ="Website Ranking Ai Blog : Elevate Your Website's Performance with AI-Powered Insights - Unlocking Your Website's Potential, One Rank at a Time";
		//System.out.println("--------title------"+actual);
		Assert.assertEquals(actual, expected, " Blog page title mismatch ");
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
		
	
	
	
	
	
	
}
