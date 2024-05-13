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
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Dashboard']")
	private WebElement dashboardBtn;
	
	
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Security and Privacy']")
	private WebElement securityAndPrivacyBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Performance and Technical']")
	private WebElement performanceAndTechnicalBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='SEO']")
	private WebElement SEOBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Mobile Responsiveness']")
	private WebElement mobileResponsivenessBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Content and Information']")
	private WebElement contentAndInformationBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Business Presence']")
	private WebElement businessPresenceBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Branding and Visual Identity']")
	private WebElement brandingAndVisualIdentityBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Interactivity and Engagement']")
	private WebElement interactivityAndEngagementBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Navigation']")
	private WebElement navigationBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Accessibility']")
	private WebElement accessibilityBtn;
	
	@FindBy(xpath="//a[@class='iq-waves-effect']/span[text()='Integration and Services']")
	private WebElement integrationAndServicesBtn;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}

	public WebElement getDashboardBtn() {
		return dashboardBtn;
	}

	public WebElement getSecurityAndPrivacyBtn() {
		return securityAndPrivacyBtn;
	}

	public WebElement getPerformanceAndTechnicalBtn() {
		return performanceAndTechnicalBtn;
	}

	public WebElement getSEOBtn() {
		return SEOBtn;
	}

	public WebElement getMobileResponsivenessBtn() {
		return mobileResponsivenessBtn;
	}

	public WebElement getContentAndInformationBtn() {
		return contentAndInformationBtn;
	}

	public WebElement getBusinessPresenceBtn() {
		return businessPresenceBtn;
	}

	public WebElement getBrandingAndVisualIdentityBtn() {
		return brandingAndVisualIdentityBtn;
	}

	public WebElement getInteractivityAndEngagementBtn() {
		return interactivityAndEngagementBtn;
	}

	public WebElement getNavigationBtn() {
		return navigationBtn;
	}

	public WebElement getAccessibilityBtn() {
		return accessibilityBtn;
	}

	public WebElement getIntegrationAndServicesBtn() {
		return integrationAndServicesBtn;
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
