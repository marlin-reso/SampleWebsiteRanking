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
	
	public void logoutAction()
	{
		muiAvatarBtn.click();
		logoutBtn.click();
		
	}

}
