package WB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterConfirmationPage {
	
	@FindBy(xpath = "//a[text()='Continue as a new user']")
	private WebElement  continueAsNewUserBtn;
	
    public RegisterConfirmationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }

	public WebElement getContinueAsNewUserBtn() {
		return continueAsNewUserBtn;
	}
    
    public void clickOnContinueAsNewUser()
    {
    	continueAsNewUserBtn.click();
    	
    }
    
	
	

}
