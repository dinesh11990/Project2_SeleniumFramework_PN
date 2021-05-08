package com.inet.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ReadConfig {
	
	Properties pro;
//As soon as you create object for ReadConfig, this read config 
//constructor will be invoked and the property file will be loaded
	public ReadConfig(){
	try{
		
	File src=new File("./Configuration/config.properties");
	
	//To read data in read mode we use FileInputStream
	FileInputStream fis = new FileInputStream(src);
	
	//Now initiate the properties
	pro = new Properties();
	
	//Load method which load the complete file
	//If the file is not available it ll give the exception
	
	pro.load(fis);
	}catch(Exception e)
	{
		System.out.println("Exception is "+ e.getMessage());
	}}
	//Create mutiple method to invoke from config properties 
	//same like LoginPageObjects
	//Get application URL
/*--------------------------------------------------------------*/
	public String getApplicationURL(){
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername(){
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword(){
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath(){
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath(){
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxPath(){
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
}
