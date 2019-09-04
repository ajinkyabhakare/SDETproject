package com.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Utilities.Readconfig;

public class Base {
	
    Readconfig rc=new Readconfig();
    
    public String username=rc.getusername();
    public String password=rc.getpassword();
    public String url=rc.geturl();
    
    
    
    public WebDriver driver;
	public Logger logr;//imported from org.apache.log4j	
    
	
    
    @BeforeTest
	public void setup() throws IOException	
	{
    	logr=logr.getLogger("com.SDETProject");
    	PropertyConfigurator.configure("log4j.properties");
	    
    	driver=new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	

	
	}
	
	@AfterTest
	public void teardown()
	{
	 	
	}
	
	public void takescreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File file=ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(file,target);
		System.out.println("screenshot taken");
		
	}
	//8 is the index that much random string get generated
		public String randomstring()//generate random string
		{
			String generaterandomstring=RandomStringUtils.randomAlphabetic(8);//for this we required java.lang3 exe file
			return generaterandomstring;
			
		}
}
