package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends Base_page{

	//constructor
	public Login_page(WebDriver driver) {
		super(driver);
	}
	
	//elements
	@FindBy(id = "input-email") 	WebElement txt_emailaddress;
	@FindBy(id ="input-password")	 WebElement txt_pswd;
	@FindBy(xpath ="//button[@class='btn btn-primary']")	 WebElement btn_login;
	
	public void setEmailaddress(String email) {
		txt_emailaddress.sendKeys(email);
	}
	
	public void setpswd(String pswd) {
		txt_pswd.sendKeys(pswd);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
}
