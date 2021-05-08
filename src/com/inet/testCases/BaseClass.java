package com.inet.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import com.inet.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
//Instead of give the data directly, take the values from config property file
	public String baseURL=readconfig.getApplicationURL() ;
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

/*---------------------------------------------------------------------------*/
	@Parameters("browser")
	@BeforeClass
	
public void setup(String br)

{ 	 
		 logger=Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties");
		 			 
if(br.equalsIgnoreCase("chrome")){
	
//Before read config file
//System.setProperty("webdriver.chrome.driver",
//System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	
	
	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		 }
		 else if(br.equalsIgnoreCase("firefox"))
		 {
	System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			 driver=new FirefoxDriver();
		 }
		 else if(br.equalsIgnoreCase("ie"))
		 {
    System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			 driver=new InternetExplorerDriver();
		 }
		 
		 driver.get(baseURL);
		
	 }

/*---------------------------------------------------------------------------*/
	
	@AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }



public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	
}
}