package WB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	@FindBy(xpath="//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1llrwy8']")
	private WebElement muiAvatarBtn;
	
	@FindBy(xpath="//button[@class='logoutbtn']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//nav[@class='iq-sidebar-menu']")
	private WebElement navigationBar;
	
	@FindBy(xpath="//input[@placeholder='Find Stats of Competitors...']")
	private WebElement searchBarTxtField;
	
	@FindBy(xpath="//footer[@class='bg-white iq-footer mt-4']/div[1][@class='container-fluid']")
	private WebElement footer;
	
	
	@FindBy(xpath="//a[@href=\"https://staging.websiteranking.ai\"]")
	private WebElement headerWebsiteRankingLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMuiAvatarBtn() {
		return muiAvatarBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement getNavigarionBar()
	{
		return navigationBar;
	}
	
	public WebElement getSearchBarTxtField() {
		return searchBarTxtField;
	}

	public WebElement getFooter() {
		return footer;
	}

	public WebElement getHeaderWebsiteRankingLink() {
		return headerWebsiteRankingLink;
	}

	
	public void logoutAction()
	{
		muiAvatarBtn.click();
		logoutBtn.click();
		
	}
	
	public void clickActionOnheaderWebsiteRankingLink()
	{
		headerWebsiteRankingLink.click();
	}
	
	

}
