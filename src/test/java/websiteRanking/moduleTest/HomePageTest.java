package websiteRanking.moduleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import WB.GenericUtility.BaseClass;

public class HomePageTest extends BaseClass {
	
	@Test
	public void verifyThatTheHomepageLoadsCorrectlyTest()
	{
		
		String expectedTitle = "Login | Website Ranking";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch");
		
	}
	
	
	

}
