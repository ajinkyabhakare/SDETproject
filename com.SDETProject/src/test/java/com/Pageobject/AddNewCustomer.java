package com.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	public WebDriver driver;

	public AddNewCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement newcust;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement customername;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(how=How.ID,using="dob")
	@CacheLookup
	WebElement birthdate;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement addres;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement cityname;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement statename;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement phone;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement submit;
	
	public void setnewcustomer()
	{
		newcust.click();
	}
	
	public void setname(String cname)
	{
		customername.sendKeys(cname);
	}
	
	public void setgender()
	{
		gender.click();
	}
	
	public void setbirthdate(String mm,String dd,String yy )
	{
		birthdate.sendKeys(mm);
		birthdate.sendKeys(dd);
		birthdate.sendKeys(yy);
	}
	
	public void setaddress(String addrs)
	{
		addres.sendKeys(addrs);
	}
	
	public void setcity(String city)
	{
		cityname.sendKeys(city);
	}
	
	public void setstate(String state)
	{
		statename.sendKeys(state);
	}

	public void setpin(String pinnum)
	{
		pin.sendKeys(pinnum);
	}
	
	public void setphone(String phnum)
	{
		phone.sendKeys(phnum);
	}
	
	public void setemail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setsubmit()
	{
		submit.click();
	}
}
