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

public class DashboardPageTest extends BaseClass{
	
	@Test(priority = 1)
	public void verifyThatAvailableLinksAreNotBrokenOnDashboardPageTest()
	{
		HttpsUtils httpsUtils = new HttpsUtils();
		  // Find all the links on the web page
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
	//	System.out.println("Available links " + links);
		int responseCode=0;
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			if(url != null && !url.isEmpty())
			{
				responseCode = httpsUtils.getResponseCode(url);
				/*
				 * Here we can add multiple status code to test the response.
				 */
				if(responseCode == HttpURLConnection.HTTP_OK);
				System.out.println("Link "  + url + " is not broken." );
			}else {
				System.out.println("Link " + url + " is broken (HTTP response code: " + responseCode +")");
			}
		}
		
	}
	@Test(priority = 2)
	public void verifyThatHomePageIsDisplayedAfterLoginTest()
	{
		
		String expectedTitle = "Login | Website Ranking";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch");
		
	}
	
	@Test(priority = 3)
	public void verifyThatUserNameIsDisplayedOnHomepageTest() throws IOException
	{
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		//String firstLetter = USERNAME.charAt(0);
		String actual = String.valueOf(USERNAME.charAt(0));
		
	//	System.out.println("first later of username is ---- "+firstLetter);
		
		HomePage hp = new HomePage(driver);
		WebElement usernameElement = hp.getMuiAvatarBtn();
		String expected = usernameElement.getText();
		
	//	Assert.assertEquals(actual, expected);
		
		if(actual.equalsIgnoreCase(expected))
		{
		  Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(true);
		}
		
	}
	
	
	@Test(priority = 4)
	public void verifyThatFeaturedFunctionArePresentOnHomePageTest()
	{
		HomePage hp = new HomePage(driver);
		
		if(hp.getDashboardBtn().isEnabled())
		{
			Assert.assertTrue(true, "Dashboard button is enabled ");
		}
		else {
			Assert.assertFalse(true, "Dashboard button is disabled");
		}
		
		
		
		if(hp.getSecurityAndPrivacyBtn().isEnabled())
		{
			Assert.assertTrue(true, "Security and Privacy button is enabled");
		}
		else {
			Assert.assertFalse(true, "Security and Privacy button is disabled");
		}
		
		
		if(hp.getPerformanceAndTechnicalBtn().isEnabled())
		{
			Assert.assertTrue(true, "Performance and Technical button is enabled");
		}
		else {
			Assert.assertFalse(true, "Performance and Technical button is disabled");
		}
		
		
		if(hp.getSEOBtn().isEnabled())
		{
			Assert.assertTrue(true, "SEO button is enabled");
		}
		else {
			Assert.assertFalse(true, "SEO button is disabled");
		}
		
		
		if(hp.getMobileResponsivenessBtn().isEnabled())
		{
		Assert.assertTrue(true, "Mobile Responsiveness button is enabled");
		}
		else {
			Assert.assertFalse(true, "Mobile Responsiveness button is disabled");
		}
		
		
		if(hp.getContentAndInformationBtn().isEnabled())
		{
		Assert.assertTrue(true, "Content and information button is enabled");
		}
		else {
			Assert.assertFalse(true, "Content and information button is disabled");
		}
		
		
		
		if(hp.getBusinessPresenceBtn().isEnabled())
		{
			Assert.assertTrue(true, " Business presence button is enabled");
		}
		else {
			Assert.assertFalse(true, "Business presence button is disabled");
		}
		
		
		if(hp.getBrandingAndVisualIdentityBtn().isEnabled())
		{
			Assert.assertTrue(true, "Branding and visual identity button is enabled");
		}
		else {
			Assert.assertFalse(true, "Branding and visual identity button is disabled");
		}
		
		
		if(hp.getInteractivityAndEngagementBtn().isEnabled())
		{
		Assert.assertTrue(true, "Inter activity and engagement button is enabled");
		}
		else {
			Assert.assertFalse(true, "Inter activity and engagement button is disabled");
		}
		
		
		if(hp.getNavigationBtn().isEnabled())
		{
			Assert.assertTrue(true, "Navigation button is enabled");
		}
		else {
			Assert.assertFalse(true, "Navigation button is disabled");
		}
		
		
		if(hp.getAccessibilityBtn().isEnabled())
		{
			Assert.assertTrue(true, "Accessibility button is enabled");
		}
		else {
			Assert.assertFalse(true, "Accessibility button is disabled");
		}
		
		
		if(hp.getIntegrationAndServicesBtn().isEnabled())
		{
			Assert.assertTrue(true, "Integration and service button is enabled");
		}
		else {
			Assert.assertFalse(true, "Integration and service button is disabled");
		}
		
		

	}
	@Test(priority = 5)
	public void verifyThatSearchFunctionalityIsPresentOnHomePageTest()
	{
		HomePage hp = new HomePage(driver);
		
		/*
		 * Following Condition to check that is Search field is enabled or not.
		 */
		
		if(hp.getSearchBarTxtField().isEnabled())
		{
			Assert.assertTrue(true, "Dashboard page Search field is enabled.");
		}
		else 
		{
			Assert.assertFalse(true, "Dashboard page Search field is disabled");
		}
		
		/*
		 * Following Condition to check that is Search field is displayed or not.
		 */
		
		if(hp.getSearchBarTxtField().isDisplayed())
		{
			Assert.assertTrue(true, "Dashboard page Search field is displayed");
		}
		else
		{
			Assert.assertFalse(true, "Dashboard page Search field is not displayed");
		}
		
	}
	
	@Test(priority = 6)
	public void verifyThatProductsDisplayedOnHomePageAreClickable()
	{
		HomePage hp = new HomePage(driver);
		
		List<WebElement> products = driver.findElements(By.xpath("//*[contains(@class, 'iq-waves-effect')]"));
		System.out.println("  products are  \n"+ products);
		//  List<WebElement> products = driver.findElements(By.xpath("//*[contains(@class, 'iq-waves-effect')]"));
	
		for(WebElement product : products)
		{
			
			if(wUtils.waitForElementToBeClickable(product, driver)) {
				
				
				System.out.println("Product is clickable : " + product.getText());
			}
			else {
				System.out.println("Product is not clickable: " + product.getText());
			}
				
				
			
		}
		
		
	
	}
	
	/*
	 *   Verify that each product element is clickable by checking if it has an href attribute or if it has an onclick event handler attached.

        // Find all product elements on the home page
        List<WebElement> products = driver.findElements(By.className("product")); // Adjust the locator as per your HTML structure

        // Iterate through each product element and verify clickability
        for (WebElement product : products) {
            // Verify if the product element is clickable
            if (isClickable(product)) {
                System.out.println("Product is clickable: " + product.getText());
            } else {
                System.out.println("Product is not clickable: " + product.getText());
            }
        }

	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
