package com.nopCommerce.testCases;

import java.io.IOException;



import org.testng.Assert;

import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void login() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is provided");//Logger msg

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username provided");//Logger msg
		lp.setPassword(password);
		logger.info("Password is provided");//Logger msg
		lp.clickLogin();
		logger.info("Login is Clicked");//Logger msg
		Thread.sleep(3000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			logger.info("Login is Passed");//Logger msg
			lp.clickLogout();
		}
		else {
			captureScreen(driver,"Login_Flow");
			Assert.assertTrue(false);
			logger.info("Login is Failed");//Logger msg
		}

	}

}
