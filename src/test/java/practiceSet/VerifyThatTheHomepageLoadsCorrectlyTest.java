package practiceSet;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WB.GenericUtility.BaseClass;
import WB.ObjectRepository.HomePage;
import WB.ObjectRepository.PreLoginPage;

public class VerifyThatTheHomepageLoadsCorrectlyTest extends BaseClass {
	@Test(priority = 1)
	public void verifyThatTheHomepageLoadsCorrectlyTest()
	{
		
		String expectedTitle = "Login | Website Ranking";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch");	
		
	}
	
	@Test(priority = 2)
	public void verifyThatNavigationBarIsDisplayedTest()
	{
		
		HomePage hp = new HomePage(driver);
		WebElement navigationBar = hp.getNavigarionBar();
		Assert.assertTrue(navigationBar.isDisplayed(),"Navigarion bar is not present");
	}
	
	@Test(priority = 3)
	public void verifyThatSearchBarIsDisplayedTest()
	{
		
		HomePage hp = new HomePage(driver);
		WebElement searchBarTxtField = hp.getSearchBarTxtField();
		Assert.assertTrue(searchBarTxtField.isDisplayed(),"Search bar is not present");
		
		
	}
	@Test(priority = 4)
	public void verifyThatFooterIsDisplayedTest()
	{
		
		HomePage hp = new HomePage(driver);
		WebElement footer = hp.getFooter();
		Assert.assertTrue(footer.isDisplayed(),"Footer is not present");
		
		
		
		
	}
	
/*
 * // Example using CSS selector to locate the footer element
WebElement footer = driver.findElement(By.cssSelector("footer"));

// Verify if the footer exists
Assert.assertTrue(footer.isDisplayed(), "Footer is not present");


 * 
 * 
 * // Example using ID to locate the search bar element
WebElement searchBar = driver.findElement(By.id("search"));

// Verify if the search bar exists
Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not present");

 * 
 * 
 * WebElement navigationBar = driver.findElement(By.cssSelector("nav"));

// Verify if the navigation bar exists
Assert.assertTrue(navigationBar.isDisplayed(), "Navigation bar is not present");
 * 
 * 
 * 
 * 
 * 
 * // Open the homepage
        driver.get(baseUrl);

        // Verify that the page title contains the expected text
        String expectedTitle = "Website Ranking | Monitor Website Rankings & SEO with AI";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch");

        // You can add more assertions here to verify other aspects of the homepage if needed
    }
 */
	
	
	
}
