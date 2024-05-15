package WB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WB.GenericUtility.WebDriverUtility;

public class PreLoginPage extends WebDriverUtility {
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	private WebElement signupBtn;
	
	@FindBy(xpath="//input[@id='searchInput']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@id='searchBtn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-style'  and text()='Get Started']")
	private WebElement getStartedBtn;
	
	@FindBy(xpath="//a[@href='top100.html']")
	private WebElement websiteTop100Btn;
	
	@FindBy(xpath="//a[@href='https://blog.websiteranking.ai/' and @class='nav-link']")
    private WebElement blogBtn;
	
	@FindBy(xpath="//a[@href='why_us.html' and @class='nav-link']")
	private WebElement whyUsBtn;
	
	
	public PreLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBlogBtn() {
		return blogBtn;
	}

	public WebElement getWhyUsBtn() {
		return whyUsBtn;
	}
	
	
	public WebElement getWebsiteTop100Btn() {
		return websiteTop100Btn;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignupBtn() {
		return signupBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getGetStartedBtn() {
		return getStartedBtn;
	}
	
	public void clickOnGetStartedBtn()
	{
		getStartedBtn.click();
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	public void clickOnSignupBtn()
	{
		signupBtn.click();	
	}
	
	public void clickOnTop100Btn()
	{
		websiteTop100Btn.click();
	}
	
	public void clickOnBlogBtn()
	{
		blogBtn.click();
	}
	public void clickOnWhyUsBtn()
	{
		whyUsBtn.click();
	}
	
	

}
