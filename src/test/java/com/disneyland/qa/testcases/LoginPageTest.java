package com.disneyland.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disneyland.qa.Testbase.TestBase;
import com.disneyland.qa.pages.HomePage;
import com.disneyland.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	  HomePage HomePge;
	  LoginPage LoginPge;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 HomePge = new HomePage();
		 LoginPge = new LoginPage();
		 LoginPge = HomePge.SignInOrCreateAccount();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title =LoginPge.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Personal Account Login | Disneyland Resort");
		
	}
	@Test(priority=2)
	public void LoginPageLogoTest() {
		boolean flag = LoginPge.ValidateSignInHeaderLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginTest() {
		HomePge = LoginPge.Validatesignin(prop.getProperty("email"), prop.getProperty("password"));
	}	
	
	
	@AfterMethod
	public void TestClose() {
		driver.quit();
	}
}
