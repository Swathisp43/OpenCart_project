package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_class {
	
public static WebDriver driver;
public Logger logger;
public ResourceBundle rb;

	@BeforeClass(groups = {"Regression","Sanity", "Master"})
	@Parameters("browser")
	public void Steup(String br) {		
	
		rb = ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass());  //logs to get the name of the current class

		if(br.equals("chrome"))	{
		driver = new ChromeDriver();
	}
		else if(br.equals("edge"))	{
			driver = new EdgeDriver();
		}
		if(br.equals("firefox"))	{
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies(); 
		driver.get(rb.getString("appURL"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	@AfterClass(groups = {"Regression","Sanity", "Master"})
	public	void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
	 String	generatedString =	RandomStringUtils.randomAlphabetic(6);
	 return(generatedString);
	}
	
	public String randomAlphaNumeric() {
		String Alpnum = RandomStringUtils.randomAlphanumeric(4);
		String num =  RandomStringUtils.randomNumeric(4);
		return (Alpnum + num);	
	}
	public String captureScreen(String tname ) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
