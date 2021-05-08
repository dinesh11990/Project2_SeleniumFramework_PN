package com.inet.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet.pageObjects.LoginPageObject;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);
		
		
		logger.info("Entered username");
		
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setUserName(username);
		
		logger.info("Entered username");
		lp.setPassword(password);
		
		logger.info("Entered password");
		lp.clickSubmit();
		
		
		
if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
