package nopcommerce_V1_maven.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalogue 
{
	
	
	public WebDriver ldriver;
	
	//Constructor
	public Catalogue (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	// Main page - home page 
	
	// Clicking on catelogue icon for list 
			// element + action
	@FindBy(xpath="//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='main-sidebar']/div[@class='sidebar']/ul[@class='sidebar-menu tree']/li[2]/a[1]/i[2]")
	@CacheLookup
	WebElement clkCatalogue;
	
	public void clkCatalogue()
	{ 
		clkCatalogue.click();
	}
	
	// Catelogue  // 1 // Products Section
	////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Catelogue ->  
		// 1st option in drop down - 1 // product page (click)
	
	@FindBy(xpath="//a[@href='/Admin/Product/List']")
	@CacheLookup
	WebElement clkproductpage;
	
	public void clkproductpage()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(clkproductpage));
		clkproductpage.click();
	}
	
	// 1 - Product Page getting all elements for the page 
			// Send keys to text field Product name 
	@FindBy(xpath="//input[@id='SearchProductName']")
	@CacheLookup
	WebElement txtProductName;
	
	public void txtProductName(String pname)
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtProductName));
		txtProductName.sendKeys(pname);
	}
	
	// 1 - Product name - category (drop down)
	
	@FindBy(xpath="//*[@id=\"SearchCategoryId\"]")
	@CacheLookup
    WebElement drpDwnSelect;

	public void drpDwnSelect()
	{

	  	drpDwnSelect.click();
        Select dropdown = new Select(drpDwnSelect);
        dropdown.getOptions().get(3).click();

	}
	
	// 1 Product name -> Warehouse
	@FindBy(xpath="//*[@id=\"SearchWarehouseId\"]")
	@CacheLookup
	WebElement drpDwnWarehouse;
	
	public void drpDwnWarehouse()
	{
		drpDwnWarehouse.click();
		Select dropDwn = new Select(drpDwnWarehouse);
		dropDwn.getOptions().get(2).click();
	}
	
	// 1 Product name -> Manufacturing
	@FindBy(xpath="//*[@id=\"SearchManufacturerId\"]")
	@CacheLookup
	WebElement drpDwnManufacturing;
	
	
	public void drpDwnManufacturing()
	{
		drpDwnManufacturing.click();
		Select drpDwn = new Select(drpDwnManufacturing);
		drpDwn.getOptions().get(3).click();
		drpDwn.getOptions().get(3).isSelected();
		
	}
	/*
	@FindBy(linkText="Categories")
	@CacheLookup
	WebElement LnkText;
	
	public void LnkText()
	{
		LnkText.click();
	}
	*/
	
	// 1 // catalog - products - 
	// Now Selecting the values from the table and checking how many are there 
	
	// Table (Row + col)
	// Cliking on the first radio box
	@FindBy(xpath="//*[@id=\"products-grid\"]/tbody/tr[1]/td[1]/input")
	@CacheLookup
	WebElement productTable;
	
	public void productTable()
	{
		productTable.click();
	}
	
	
	public void productTable1() 
	{
		// All col values 
		int cols = ldriver.findElements(By.xpath("//*[@id=\"products-grid\"]/tbody/tr/td[1]/input")).size();
		
		int count =0;
		for(int c=1; c<=cols; c++)
		{
			
		String status = ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+c+"]/td[1]/input")).getText();
		if(status.equals("Enabled"))
		{
			
			count++;
		}
		System.out.println("No of users Enabled : " +count);
		System.out.println("No of users disabled : " + (cols-count));
		}
	
		// Selecting the radio button and displaying that it is selected
		String str = productTable.getAttribute("checked");
		if (str.equalsIgnoreCase("true"))
		{
		    System.out.println("Checkbox selected");
		}
	
	
	}
	
	
}
