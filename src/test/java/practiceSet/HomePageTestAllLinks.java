package practiceSet;

import org.testng.annotations.Test;

import WB.GenericUtility.BaseClass;
import WB.ObjectRepository.HomePage;

public class HomePageTestAllLinks extends BaseClass {
	
	@Test
	public void testHomePageLink()
	{
		
		HomePage hp = new HomePage(driver);
		//hp.linkTestAction();
		
		
	}
	
	
	//working

}
