package nopcommerce_V1_maven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) // Constructor 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		@FindBy(id="Email")
		@CacheLookup
		WebElement txtEmail;
		
		@FindBy(id="Password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@value='Log in']")
		@CacheLookup
		WebElement btnlogin; 
		
		@FindBy(linkText="Logout")
		@CacheLookup
		WebElement lnkLogout;
		
		
		public void setUserName(String uname)
		{
			txtEmail.sendKeys(uname);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		public void clickLogin()
		{
			btnlogin.click();
		}
		public void clickLogout()
		{
			lnkLogout.click();
		}
		
	}


