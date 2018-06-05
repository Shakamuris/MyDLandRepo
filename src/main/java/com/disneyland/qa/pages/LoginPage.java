package com.disneyland.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneyland.qa.Testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="signInHeaderImage")
	WebElement Logo;
	@FindBy(xpath="//input[@name='username']")
	WebElement EmailOrUserName;
	@FindBy(xpath="//input[@id='loginPagePassword']")
	WebElement Password;
	@FindBy(xpath="//button[@id='loginPageSubmitButton']")
	WebElement Submit;
	@FindBy(xpath="//a[@href='/registration/']")
	WebElement CreateAccount;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateSignInHeaderLogo() {
		return Logo.isDisplayed();
	}
	public HomePage Validatesignin(String un, String pwd) {
		EmailOrUserName.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();
		return new HomePage();
	}
	public RegistrationPage ClickOnCreateAccount() {
		CreateAccount.click();
		return new RegistrationPage();
	}
}
