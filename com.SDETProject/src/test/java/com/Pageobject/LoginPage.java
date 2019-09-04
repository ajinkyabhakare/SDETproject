package com.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement logout;
	
	
	
	public void setusername(String user)
	{
		username.sendKeys(user);
	}
	
	public void setpassword(String pass)
	{ 
		password.sendKeys(pass);
	}
	
	public void setlogin()
	{
		login.click();
	}
	
	public void setlogout()
	{
	   logout.click();	
	}
}
