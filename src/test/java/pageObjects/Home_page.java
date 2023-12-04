package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends Base_page{

	public Home_page(WebDriver driver) {
		super(driver);
	}
	//Elements
	@FindBy(linkText ="My Account")    WebElement lnk_myaccount;
	
	@FindBy(linkText = "Register")	   WebElement lnk_register;
	
	@FindBy(linkText = "Login")        WebElement link_login;
	
	//Actions
	public void clickAccount() {
	lnk_myaccount.click();
		}
	
	public void clickRegister() {
	lnk_register.click();
	}
	
	public void clickLogin() {
		link_login.click();
	}
	
}
