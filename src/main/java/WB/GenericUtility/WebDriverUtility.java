package WB.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist all the web driver related methods.
 * @author SanjayGiri
 */
public class WebDriverUtility {
	
	
	/**
	 * This method will maximise the window.
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{	
		try {
		driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will minimise the Window.
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		try {
		driver.manage().window().minimize();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will apply implicit wait on driver.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		try{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will apply wait until webElement will ready to visible.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{	
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will apply wait until element will ready to click.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * This method will return the boolean value to check that element is clickable or not.
	 * @param element
	 * @param driver
	 * @return
	 */
	public boolean waitForElementToBeClickable(WebElement element, WebDriver driver)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//if WebDriver doesn't throw an exception, the element is clickable.
		return true;
		
		}catch(Exception e) {
			//If WebEriverWait throws an exception, the element is not clickable.
			return false;
			
		}
	}
	
	
	/**
	 * This method will handle the dropdown based on index.
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		try {
		Select sal = new Select(element);
		sal.selectByIndex(index);
		}catch(Exception e)
		{
			e.printStackTrace();	}
	}
	
	/**
	 * This method will handle the dropdown based on value.
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		try {
		Select sal = new Select(element);
		sal.selectByValue(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will handle the dropdown based on visible text.
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		try {
		Select sal = new Select(element);
		sal.selectByVisibleText(text);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform mouse hover action.
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		try {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will perform click action.
	 * @param driver
	 */
	public void mouseClickAction(WebDriver driver)
	{
		try {
		Actions act = new Actions(driver);
		act.click().perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform click action on target web element.
	 * @param driver
	 * @param element
	 */
	public void mouseClickAction(WebDriver driver, WebElement element)
	{
		try {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform right click action.
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		try {
		Actions act = new Actions(driver);
		act.contextClick().perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform right click action on target element.
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		try {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	
	/**
	 * This method will perform double click action.
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		try {
		Actions act = new Actions(driver);
		act.doubleClick();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform double click action on target web element.
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		try {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform drag and drop method.
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement source, WebElement target)
	{
		try {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will accept the alert.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		try {
		driver.switchTo().alert().accept();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will dismiss the alert.
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		try {
		driver.switchTo().alert().dismiss();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the alert text.
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		
		return driver.switchTo().alert().getText();
		}
		 	
		
		
	
	
	/**
	 * This method will switch the frame based on index number.
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		try {
		driver.switchTo().frame(index);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will switch the frame based on name or id.
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId)
	{
		try {
		driver.switchTo().frame(nameOrId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will switch the frame based on name or id.
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		
		try {
		driver.switchTo().frame(frameElement);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will switch the frame based on parent frame.
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		try {
		driver.switchTo().parentFrame();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will switch the frame based on default frame.
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		try {
		driver.switchTo().defaultContent();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will switch the window based n partial window title.
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		try {
		//Capture all the window id's
		Set<String> winId = driver.getWindowHandles();
		
		//navigate to the each windows
		for(String win:winId)
		{
			//switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
			
			//compare the title with required partial title
			if(winTitle.contains(partialWinTitle))
			{
				break;
			}
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will capture the screen.
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenShots\\"+screenShotName+".png");
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath(); // This will be used for extent report 
			
	}
	
	/**
	 * This method will perform random scroll downwards vertically.
	 * @param driver
	 */
	public void scrollActions(WebDriver driver)
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("0.500", " ");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will scroll until the element is identified in DOM(document object module).
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	

}
