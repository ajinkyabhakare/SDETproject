package com.Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pageobject.AddNewCustomer;
import com.Pageobject.LoginPage;

public class Newcustomer_003 extends Base {
	
	@Test
	
	public void newcustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		AddNewCustomer nc=new AddNewCustomer(driver);
		
		logr.info("url opened");
		lp.setusername(username);
		lp.setpassword(password);
		lp.setlogin();
		logr.info("login done");
		Thread.sleep(2000);
		
		nc.setnewcustomer();
		nc.setname("ajinkya");
		logr.info("name entered");
		nc.setgender();
		Thread.sleep(2000);
		
		nc.setbirthdate("01","01","1989");
		nc.setaddress("c302 royal castle thergao pune");
		nc.setcity("pune");
		logr.info("date and address entered");
		Thread.sleep(2000);
		
		nc.setstate("maharashtra");
		nc.setpin("413722");
		nc.setphone("8329074273");
		String email=randomstring()+"@gmail.com";
		nc.setemail(email);
		logr.info("mail id entered");
		nc.setpassword("ajinkya");
		nc.setsubmit();
		logr.info("submit all form");
		
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true)
		{
			Assert.assertTrue(true);
			logr.info("informatiom matched-----test successful");
		}
		else 
		{
			takescreenshot(driver,"newcustomer");
			logr.info("screenshot taken");
			Assert.assertTrue(false);
			
		}
		
		
	}
	

}
