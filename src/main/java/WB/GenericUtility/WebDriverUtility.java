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
		driver.manage().window().maximize();	
	}
	
	
	/**
	 * This method will minimise the Window.
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().minimize();	
	}
	
	/**
	 * This method will apply implicit wait on driver.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	/**
	 * This method will apply wait until webElement will ready to visible.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	/**
	 * This method will apply wait until element will ready to click.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle the dropdown based on index.
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sal = new Select(element);
		sal.selectByIndex(index);
	}
	
	/**
	 * This method will handle the dropdown based on value.
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		
		Select sal = new Select(element);
		sal.selectByValue(value);
		
	}
	
	/**
	 * This method will handle the dropdown based on visible text.
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sal = new Select(element);
		sal.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action.
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/**
	 * This method will perform click action.
	 * @param driver
	 */
	public void mouseClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
	}
	
	/**
	 * This method will perform click action on target web element.
	 * @param driver
	 * @param element
	 */
	public void mouseClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method will perform right click action.
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click action on target element.
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click action.
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		
		Actions act = new Actions(driver);
		act.doubleClick();
		
	}
	
	/**
	 * This method will perform double click action on target web element.
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop method.
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement source, WebElement target)
	{
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		
	}
	
	/**
	 * This method will accept the alert.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert.
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
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
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method will switch the frame based on name or id.
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId)
	{
		
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch the frame based on name or id.
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will switch the frame based on parent frame.
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the frame based on default frame.
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch the window based n partial window title.
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
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
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("0.500", " ");
		
	}
	
	/**
	 * This method will scroll until the element is identified in DOM(document object module).
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}	

}
