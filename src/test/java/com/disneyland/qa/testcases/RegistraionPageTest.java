package com.disneyland.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disneyland.qa.Testbase.TestBase;
import com.disneyland.qa.pages.HomePage;
import com.disneyland.qa.pages.LoginPage;
import com.disneyland.qa.pages.RegistrationPage;

public class RegistraionPageTest extends TestBase {
	  HomePage HomePge;
	  LoginPage LoginPge;
	  RegistrationPage RegiObj;

	public RegistraionPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 HomePge = new HomePage();
		 LoginPge = new LoginPage();
		 RegiObj = new RegistrationPage();
		 LoginPge = HomePge.SignInOrCreateAccount();
	}
	
	@Test
	public void SelectTitleTest() {
		LoginPge.ClickOnCreateAccount();
		RegiObj.ValidateSelectTitle();
		
	}
	
	@AfterMethod
	public void TestClose() {
		driver.quit();
	}
}
