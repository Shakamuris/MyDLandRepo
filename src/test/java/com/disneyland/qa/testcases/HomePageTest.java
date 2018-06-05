package com.disneyland.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disneyland.qa.Testbase.TestBase;
import com.disneyland.qa.pages.HomePage;
import com.disneyland.qa.pages.LoginPage;
import com.disneyland.qa.pages.TicketsPage;

public class HomePageTest extends TestBase {
		HomePage HomePageobj;
		LoginPage LoginPageobj;
		
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 HomePageobj = new HomePage();
		 LoginPageobj = new LoginPage();
		
	}
	
	@Test(priority=3)
	public void ClickonSignInTest() {
		LoginPageobj = HomePageobj.SignInOrCreateAccount();
	}
	
	@Test(priority=1)
	public void ValidateGlobalHeaderLinksTest() {
		HomePageobj.ValidateParksAndTickets();
		HomePageobj.ValidatePlacesToStay();
		HomePageobj.ValidateThingsToDo();
		HomePageobj.ValidateShop();
		HomePageobj.ValidateAnnualPassports();
		HomePageobj.ValidateHelp();
	}
	/*public void ParksAndTicketsLinkTest() {
		HomePageobj.ValidateParksAndTickets();	
	}
	public void PlacesToStayLinkTest() {
		HomePageobj.ValidatePlacesToStay();
	}
	public void ThingsToDoLinkTest() {
		HomePageobj.ValidateThingsToDo();	
	}
	public void ShopLinkTest() {
		HomePageobj.ValidateShop();	
	}
	public void AnnualPassportsLinkTest() {
		HomePageobj.ValidateAnnualPassports();
	}
	public void HelpLinkTest() {
		HomePageobj.ValidateHelp();
	}
	public void CartLinkTest() {
		HomePageobj.ValidateCart();
	}*/
	
	
	@Test(priority=2)
	public void HotelFromCartLinkTest() {
		HomePageobj.ValidateHotelFromCart();
	}
	
	@AfterMethod
	public void TestClose() {
		driver.quit();
	}
}