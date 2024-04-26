package WB.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WB.GenericUtility.ExcelFileUtility;
import WB.GenericUtility.JavaUtility;
import WB.GenericUtility.PropertyFileUtility;
import WB.GenericUtility.WebDriverUtility;

public class RegisterPage extends WebDriverUtility{
	
	@FindBy(xpath="//a[text()='Login here!']")
	private WebElement loginHereLink;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameTxtField;
	
	@FindBy(xpath="//input[@value='+91']")
	private WebElement phoneNoTxtField;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailTxtField ;
	
	@FindBy(xpath="//input[@id='url']")
	private WebElement websiteDomainTxtField ;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement createPasswordTxtField ;
	
	@FindBy(xpath="//input[@id='c_password']")
	private WebElement confirmPasswordTxtField ;
	
	@FindBy(xpath="//input[@id='rememberme']")
	private WebElement agreeToOurTermsOfUseCheckBox ;
	
	@FindBy(xpath="//button[text()='Get Started']")
	private WebElement getStartedBtn ;
	
	@FindBy(xpath="//button[@class='btn border-light google-btn']")
	private WebElement countinueWithGoogleBtn ;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginHereLink() {
		return loginHereLink;
	}

	public WebElement getNameTxtField() {
		return nameTxtField;
	}

	public WebElement getPhoneNoTxtField() {
		return phoneNoTxtField;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getWebsiteDomainTxtField() {
		return websiteDomainTxtField;
	}

	public WebElement getCreatePasswordTxtField() {
		return createPasswordTxtField;
	}

	public WebElement getConfirmPasswordTxtField() {
		return confirmPasswordTxtField;
	}

	public WebElement getAgreeToOurTermsOfUseCheckBox() {
		return agreeToOurTermsOfUseCheckBox;
	}

	public WebElement getGetStartedBtn() {
		return getStartedBtn;
	}

	public WebElement getCountinueWithGoogleBtn() {
		return countinueWithGoogleBtn;
	}
	
	public void signupToYourAccount() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eUtils = new ExcelFileUtility();
		PropertyFileUtility pUtils = new PropertyFileUtility();
		JavaUtility jUtils = new JavaUtility();
		
		String phoneNo = pUtils.readDataFromPropertyFile("phoneNo")+jUtils.getRandomNumber();
		String name = eUtils.readDataFromExcelFile("signupPage", 1, 0);
	//	System.out.println("name "+name);
		
		String email = eUtils.readDataFromExcelFile("signupPage", 1, 1)+jUtils.getRandomNumber()+"@gmail.com";
	//	System.out.println( "email "+email);
		String websiteDomain = eUtils.readDataFromExcelFile("signupPage", 1, 2);
	//	System.out.println("websiteDomail "+websiteDomain);
		
		String createPassword = eUtils.readDataFromExcelFile("signupPage", 1, 3);
	//	System.out.println("createPassword "+createPassword);
		
		String confirmPassword = eUtils.readDataFromExcelFile("signupPage", 1, 4);
	//	System.out.println("confirmPassword"+confirmPassword);
		
		
		nameTxtField.sendKeys(name);
		phoneNoTxtField.sendKeys(phoneNo);
		emailTxtField.sendKeys(email);
		websiteDomainTxtField.sendKeys(websiteDomain);
		createPasswordTxtField.sendKeys(createPassword);
		confirmPasswordTxtField.sendKeys(confirmPassword);
		agreeToOurTermsOfUseCheckBox.click();
		getStartedBtn.click();
		
	}
	
	public void clickOnLoginHereLink()
	{
		loginHereLink.click();
		
	}
	
	

}
