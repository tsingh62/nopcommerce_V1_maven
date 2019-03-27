package nopcommerce_V1_maven.testCases;



import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import nopcommerce_V1_maven.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("providing user name");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("providing password");
		lp.setPassword(password);
		
		logger.info("clicking on login");
		lp.clickLogin();
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("login success");
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
		}
			else
			{
				captureScreen(driver,"loginTest");
				// to capture screen on failure and here after driver
				// we use the name of the current test method i.e. loginTest
				logger.error("login is failed");
				Assert.assertTrue(false);
		}
		
	}
	
	 

}
