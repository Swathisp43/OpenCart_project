package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount_page extends Base_page{

	public Myaccount_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[contains(text(),'My Account')]")  	WebElement msgheading;
	@FindBy(linkText ="Logout")  	WebElement btn_logout;
	
	public void clicklogout() {
		btn_logout.click();
	}
	public boolean ismyaccount_exists() {
		try {
		return(msgheading.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
		
	}
	 
	

}
