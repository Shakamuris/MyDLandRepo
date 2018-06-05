package com.disneyland.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneyland.qa.Testbase.TestBase;

public class HomePage extends TestBase {	
	
	@FindBy(name="&lid=DLR_Header_SignInCreateAccountLink")
	WebElement SignInLink;
	@FindBy(xpath="//a[contains(text(),'Disneyland Logo')]")
	WebElement DLRLogo;
	@FindBy(name="&lid=DLR_Header_ParksTickets_CategoryLink")
	WebElement ParksAndTickets;
	@FindBy(name="&lid=DLR_Header_PlaceToStay_CategoryLink")
	WebElement PlacesToStay;
	@FindBy(name="&lid=DLR_Header_ThingsToDo_CategoryLink")
	WebElement ThingsToDo;
	@FindBy(name="&lid=DLR_Header_Shop_CategoryLink")
	WebElement Shop;
	@FindBy(name="&lid=DLR_Header_AP_CategoryLink")
	WebElement AnnualPassports;
	@FindBy(name="&lid=DLR_Header_Help_CategoryLink")
	WebElement Help;
	@FindBy(xpath="//div[@class='gnbCategory gnbCart hoverable']")
	WebElement Cart;
	@FindBy(xpath="//a[@href='/hotels/']")
	WebElement HotelFromCart;
	
	
     public HomePage() {
	 PageFactory.initElements(driver, this);		
	}
     
   public LoginPage SignInOrCreateAccount() {
	 SignInLink.click();
	 return new LoginPage();
    }
	public String ValidateHomePageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateDisneyLogo() {
		return DLRLogo.isDisplayed();
	}
	public void ValidateParksAndTickets() {
		ParksAndTickets.click();
		
		
	}
    public void ValidatePlacesToStay() {
    	PlacesToStay.click();
	}
    public void ValidateThingsToDo() {
    	ThingsToDo.click();
	}
    public void ValidateShop() {
    	Shop.click();
    	driver.navigate().back();
	}
    public void ValidateAnnualPassports() {
    	AnnualPassports.click();
	}
    public void ValidateHelp() {
    	Help.click();
	}
    public void ValidateCart() {
    	Cart.click();
	}
    public void ValidateHotelFromCart() {
		Actions action = new Actions(driver);
		action.moveToElement(Cart).click(HotelFromCart).build().perform();
		
	}
}
