package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;
import testBase.Base_class;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends Base_class {
	
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class)  //dataProviderClass paramter to refer when dataprovider and TC are in diff package
	public void loginDDT(String Email, String pswd, String exp) {
		
		logger.info("*** TC_002_LoginTest started *** ");
		try {
		Home_page hp = new Home_page(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		Login_page lp = new Login_page(driver);
		lp.setEmailaddress(Email);
		lp.setpswd(pswd);
		lp.clickLogin();
		
		Myaccount_page myacc = new Myaccount_page(driver);	
		Boolean targetpage= myacc.ismyaccount_exists();
		
		if(exp.equals("Valid"))
		{
			if(targetpage ==true)
			{
				myacc.clicklogout();
				Assert.assertTrue(true);	
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(false); 
			}
			else
			{
				Assert.assertTrue(true);  //   Assert.fail();
			}
		}
		} catch(Exception e) {
			Assert.fail();
		}
	 logger.info("*** TC_002_LoginTest finished *** ");
	}
	

}
