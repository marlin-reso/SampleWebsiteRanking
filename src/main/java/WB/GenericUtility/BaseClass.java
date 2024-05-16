package WB.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import WB.ObjectRepository.HomePage;
import WB.ObjectRepository.LoginPage;
import WB.ObjectRepository.PreLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author SanjayGiri
 */
public class BaseClass {
	
	public ExcelFileUtility eUtils = new ExcelFileUtility();
	public PropertyFileUtility pUtils = new PropertyFileUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public JavaUtility jUtils = new JavaUtility();
	protected WebDriver driver;
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("-----Database connection established----");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtils.readDataFromPropertyFile("browser");
		String URL = pUtils.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			System.out.println("-------"+BROWSER+" launch succesfully  ");
			
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			System.out.println("-------"+BROWSER+" launch succesfully");
		}else
		{
			System.out.println("Invalid browser");
		}
		
		wUtils.maximizeWindow(driver);
		wUtils.implicitWait(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		
		String USERNAME = pUtils.readDataFromPropertyFile("username");
		String PASSWORD = pUtils.readDataFromPropertyFile("password");
		
		
	//	String title = driver.getTitle();
	//	System.out.println("Title----------------->"+title);
		
		PreLoginPage plp = new PreLoginPage(driver);
		plp.clickOnLoginBtn();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);	
		
		System.out.println("Login to the application succesfully");
		
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutAction();
		System.out.println("Logout from the application succesfully");
		
	}
	
	@AfterClass
	public void acConfig()
	{
		if (driver != null) {
            driver.quit();
        }
		
		//driver.quit();
		System.out.println("Closing the browser succesfully");
			
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("Database closed");
		
	}
	

}
