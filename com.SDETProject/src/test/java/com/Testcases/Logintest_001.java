package com.Testcases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pageobject.LoginPage;
import com.Utilities.Readconfig;

public class Logintest_001 extends Base {
	
	
	
	@Test
	public void logintest() throws IOException, InterruptedException
	{
		
		logr.info("url opened");
		
		LoginPage lp=new LoginPage(driver);
		logr.info("enter username");
		lp.setusername(username);
		logr.info("enter password");
		lp.setpassword(password);
		logr.info("clik logger button");
		lp.setlogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage "))
		{
			logr.info("title is ok");
			Assert.assertTrue(true);
		}
		else
		{
			takescreenshot(driver,"logintest");
			logr.info("title is not ok");
			Assert.assertTrue(false);
			
		}
		
	}
	
	
	

}
