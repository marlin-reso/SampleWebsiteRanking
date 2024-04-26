package WB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WB.GenericUtility.WebDriverUtility;


/**
 * @author SanjayGiri
 */
public class LoginPage extends WebDriverUtility{
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTxtField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTxtField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[@class='loginAgencyByn']")
	private WebElement loginAsAgencyBtn;
	
	@FindBy(xpath="//a[text()='Register here!']")
	private WebElement registerHereLink;
	
	@FindBy(xpath="//input[@id='rememberme']")
	private WebElement rememberMeCheakBox;
	
	@FindBy(xpath="//a[text()='Forgot Password']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//button[@class='btn border-light google-btn']")
	private WebElement continueWithGoogleLink;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getLoginAsAgencyBtn() {
		return loginAsAgencyBtn;
	}

	public WebElement getRegisterHereLink() {
		return registerHereLink;
	}

	public WebElement getRememberMeCheakBox() {
		return rememberMeCheakBox;
	}

	public WebElement getForgetPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getContinueWithGoogleLink() {
		return continueWithGoogleLink;
	}
	
	public void loginToApplication(String username, String password)
	{
		emailTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		submitBtn.click();
		
	}
	
	public void clickOnLoginAsAgencyBtn(WebDriver driver)
	{
		loginAsAgencyBtn.click();
			
	}
	
	public void clickOnRegisterHereLink(WebDriver driver)
	{
		
		registerHereLink.click();
	}
	
	
	public void forgetPasswordLink(WebDriver driver)
	{
		forgotPasswordLink.click();
	}
	
	public void continueWithGoogleLink(WebDriver driver)
	{
		continueWithGoogleLink.click();
	}
	

}
