package nopcommerce_V1_maven.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import nopcommerce_V1_maven.pageObjects.Catalogue;
import nopcommerce_V1_maven.pageObjects.LoginPage;

public class TC_Catalogue_Test extends BaseClass
{
	@Test(priority=1)
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		logger.info("opening base URL");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		
		logger.info("providing password");
		lp.setPassword(password);
		
		logger.info("clicking on login");
		lp.clickLogin();
		
		// Verifying login page 
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("login success");
			Thread.sleep(5000);
		//	lp.clickLogout();
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
	@Test(priority=2)
	public void catalogueProductPage() 
	{
		Catalogue ct = new Catalogue(driver);
		
		ct.clkCatalogue();
		logger.info("Clicking on Catalogue");
		
		ct.clkproductpage();
		logger.info("Clicking on Product Page");
		
		ct.txtProductName("test");
		logger.info("Product name entered");
		
		ct.drpDwnSelect();
		logger.info("Clicking on drop down and selecting value from dropdown");
		
		ct.drpDwnWarehouse();
		logger.info("Clicking on drop down warehouse and selecting value from dropdown");
		
		ct.drpDwnManufacturing();
		logger.info("Clicking on drop down manufacturing and selecting value from drop down");
		
		//ct.LnkText();
		ct.productTable();
		logger.info("Clicking on the radio button");
		
		ct.productTable1();
		logger.info("Checking table value is Enabled or not");
	}
	
}
