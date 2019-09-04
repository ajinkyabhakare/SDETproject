package com.Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pageobject.LoginPage;
import com.Utilities.XLUtils;

public class LogintestDDT_002 extends Base {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pass) throws InterruptedException 
	{
		logr.info("url opened");
	  LoginPage lp=new LoginPage(driver);
	  lp.setusername(user);
	  logr.info("username entered");
	  lp.setpassword(pass);
	  logr.info("password entered");
	  lp.setlogin();
	  logr.info("click login button");
	  if(isAlertPresent()==true)
	  {
		  logr.info("incorrect info");
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
		  logr.info("testcase failed");
		  
	  }
	  else
	  {
		  Assert.assertTrue(true);
		  logr.info("login success");
		  lp.setlogout();
		  logr.info("logout window");
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  logr.info("back to homeoage");
	  }
	  
	 
	  
	}
	
	public boolean isAlertPresent()
	{
	    try {
	    	driver.switchTo().alert();
	    	
		
		
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException, InterruptedException
	{
		XLUtils xl=new XLUtils();
		String path="E:\\CoreJavaWorkspace\\com.SDETProject\\src\\test\\java\\com\\Testdata\\Logindata.xlsx";
		int rownum=xl.getRowCount(path,"Sheet1");
		int colcount=xl.getCellCount(path,"Sheet1",1);
		
		String [][]logindata=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=xl.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
	

}
