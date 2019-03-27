package nopcommerce_V1_maven.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import nopcommerce_V1_maven.utilities.ReadConfig;

public class BaseClass 
{
	// now calling values for readConfig.java
		ReadConfig readconfig = new ReadConfig();
					// dont confure here the readconfig is the object of ReadConfig
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword(); 
	public static WebDriver driver;
	 
	
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser") // value chrome into br
	public void setup(String br)
	{
		logger = Logger.getLogger("eCommerce"); // Added logger 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
	
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		
		if (br.equalsIgnoreCase("chrome"))
			{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
														//getting Chrome path   from readcong and configProperties
			driver=new ChromeDriver();
		
			}
		else if (br.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver=new FirefoxDriver();
				
			}
			// Global implicit Wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@AfterClass
	private void tearDown() 
	{
	driver.quit();	
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	
	
}