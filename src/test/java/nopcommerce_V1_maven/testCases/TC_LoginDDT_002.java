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
	 /*
	// Data provider will always return String type of data
		// Two dimensional string type array
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			
			String path=System.getProperty("user.dir")+"/src/test/java/com/testData/LoginData.xlsx";
		
			//Read data 
			//no of rows  in the XL data sheet
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			// no of columns in the XL data sheet
			int colcount=XLUtils.getCellCount(path,"Sheet1",1); // At-least specify one row to count the no of cols
																		// present inside the row
			// Create a two dimensional string array
			// Should be the same size of that of the XL sheet
			String logindata[][]=new String[rownum][colcount]; // rownum and colcount give the exact no of values in the XL sheet
															// that is passed in logindata[][] // now the data size and array size both are equal
			// Read data and store it in a 2 dimensional array
			
			// Starting from 1 since index 0 is the header part
			for(int i=1;i<=rownum;i++)
			{
				// increment the columns
				for(int j=0;j<colcount;j++)// Since the col values start from index 0
				{
					// Extract data from XL
					// Since the data starts from index 1 for rows and 0 for col in XL sheet
					// We need to store the same value in the array
					// so the value index value for row will be i-1 since the array will 
					// store the data from and it will not be taking the header values of the XL sheet
					// for col its same as, the col reads from index 0 and saves it in the array in index 0
					
					// Get data from Xl and store in a 2 dim array
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);// i is row and j is col
					
				}
				
			}
			return logindata; // returning 2 dim arrary
		} */

 }

}
