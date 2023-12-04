package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;
import testBase.Base_class;

public class TC_002_LoginTest extends Base_class{
	

	@Test(groups = {"Sanity","Master"})
	public void testlogin() {
		
		logger.info("*** TC_002_LoginTest started *** ");
		Home_page hp = new Home_page(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		Login_page lp = new Login_page(driver);
		lp.setEmailaddress(rb.getString("email"));
		lp.setpswd(rb.getString("password"));
		lp.clickLogin();
		
		Myaccount_page myacc = new Myaccount_page(driver);
		try {
		Assert.assertEquals(true, myacc.ismyaccount_exists(), "Invalid data");
		} catch(Exception e) {
			Assert.fail();
		}
		
	 logger.info("*** TC_002_LoginTest finished *** ");
	
	}
}
