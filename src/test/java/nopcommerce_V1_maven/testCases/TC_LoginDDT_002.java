package nopcommerce_V1_maven.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nopcommerce_V1_maven.pageObjects.LoginPage;
import nopcommerce_V1_maven.utilities.XLUtiles;
@Test(dataProvider="LoginData")
public class TC_LoginDDT_002 extends BaseClass
{
	public void loginTest(String user, String pwd) throws IOException, InterruptedException
	{
	driver.get(baseURL);
	logger.info("providing user name");
	
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(user);
	
	logger.info("providing password");
	lp.setPassword(pwd);
	
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
		//	captureScreen(driver,"loginTest");
			// to capture screen on failure and here after driver
			// we use the name of the current test method i.e. loginTest
			logger.error("login is failed");
			Assert.assertTrue(false);
	} 
	
}
// Creating a data provider method
	// data provider method will always provide a string type of data
	// Two dimensional string type of array
@DataProvider(name="LoginData")
 public String [][] getData() throws IOException
 {
	 String path = System.getProperty("user.dir")+"/src/test/java/nopcommerce_V1_maven/testData/LoginData.xlsx";
	 int rownum = XLUtiles.getRowCount(path, "Sheet1");
	 int colcount = XLUtiles.getCellCount(path, "Sheet1", 1);
	
	 String logindata[][] = new String[rownum][colcount]; 
	 //We don't take i as 0 since 0 would refer to header values
	 // we take 1 from where the data starts
	 for (int i=1; i<=rownum; i++)
	 {
		 for(int j=0;j<colcount;j++)
		 {
			 logindata[i-1][j]=XLUtiles.getCellData(path, "Sheet1", i, j);
		 }
	 }
	 // returning the two dimensional array
	 return logindata;
 }

}
