package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AcctRegestriation_page;
import pageObjects.Home_page;
import testBase.Base_class;

public class TC_001_AcctRegistrationTest extends Base_class{

	@Test(groups = {"Regression","Master"})
public	void test_account_regristation() throws InterruptedException 
	{
		//logger.debug("Application logs...");
		logger.info("*** Starting TC_001_AcctRegistration ***");
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Home_page hp = new Home_page(driver);
		hp.clickAccount();		
		hp.clickRegister();
	
		
	AcctRegestriation_page regpage = new AcctRegestriation_page(driver);
	
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@yopmail.com");
		// String password = randomString(); can be used for confirm password
		regpage.setPassword(rb.getString("password"));  
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		regpage.setPrivacyPolicy();
		Thread.sleep(1000);
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
	String confmsg =	regpage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Test failed");	
		}
		catch(Exception e) {
			Assert.fail();
			logger.error("test failed");
		}
		logger.info("*** Completed TC_001 AccRegestration ***");
}	
}
