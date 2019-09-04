package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	public Properties prop;
	
	public Readconfig() 
	{
		File src=new File("E:\\CoreJavaWorkspace\\com.SDETProject\\Config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getusername()
	{
		String usr=prop.getProperty("username");
		return usr;
	}
	
	public String getpassword()
	{
		String ps=prop.getProperty("password");
		return ps;
	}

	public String geturl()
	{
		String urlname=prop.getProperty("url");
		return urlname;
	}
}
