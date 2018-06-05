package com.disneyland.qa.pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneyland.qa.Testbase.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath="//h1[contains(text(),'Disney Account')]")
	WebElement RegistrationPageHeader;
	@FindBy(xpath="//div[@class='disneyAccountLogo m-hide']")
	WebElement DisneyAccountLogo;
	@FindBy(id="email")
	WebElement EmailField;
	@FindBy(id="confirmEmail")
	WebElement ConfirmEmail;
	@FindBy(name="disIdPassword")
	WebElement Password;
	@FindBy(name="disIdConfirmPassword")
	WebElement ConfirmPassword;	
	@FindBy(xpath="//div[@aria-owns='registrationPageTitleSelect-dropdown-list']")
	WebElement SelectTitleDropDown;
	@FindBy(xpath="//ol[@id='registrationPageTitleSelect-dropdown-list']//li")
	WebElement DropdownList;
	@FindBy(id="registrationPageTitleSelect-1")
	WebElement SelectTitle;
	@FindBy(id="firstName")
	WebElement FirstName;
	@FindBy(id="lastName")
	WebElement lastName;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void ValidateSelectTitle() {
		ClickByJS(SelectTitleDropDown, driver);
		WebElement DDList= DropdownList;		
		System.out.println(DDList);
		
		SelectTitle.click();
		FirstName.sendKeys("Reddy");
		lastName.sendKeys("TheGreat");
		
	}	
	
	public static void ClickByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	
	}
}
