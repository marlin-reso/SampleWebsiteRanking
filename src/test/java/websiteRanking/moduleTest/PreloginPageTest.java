package websiteRanking.moduleTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
		
		SoftAssert softAssert = new SoftAssert();
		String actual = driver.getTitle();
	//	System.out.println("Actual Page title is "+actual);
		String expected = "Website Ranking: Website Health Analysis & Monitoring ToolKit";
        softAssert.assertEquals(actual, expected, "Pre-login page title mismatch");
		//	Assert.assertEquals(actual, expected, "Pre-login page title mismatch");
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
		SoftAssert softAssert = new SoftAssert();
		
		String actual = driver.getTitle();
		String expected = "Top 100 Websites Ranking - Most Visited Websites in March 2024 | Websiteranking.ai";
	    softAssert.assertEquals(actual, expected,"Website Top 100 page title mismatch" );
		//	System.out.println("Actual Title "+actual);
	
		//	Assert.assertEquals(actual, expected, "Website Top 100 page title mismatch");
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
	
	
	
	
	
	
	
}
