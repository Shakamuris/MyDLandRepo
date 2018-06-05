package com.disneyland.qa.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.disneyland.qa.util.TestUtilities;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;	
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Udemy_Rahul_Arora\\Selenium practiced code\\Disneyland\\src\\main\\java\\com\\disneyland\\qa\\config\\config.properties");
		prop.load(fis);	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\selenium\\Drivers-unzipped\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Automation\\selenium\\Drivers-unzipped\\geckodriver.exe");			
			 driver = new FirefoxDriver();
		}else {
	    	System.setProperty("webdriver.ie.driver", "D:\\Automation\\selenium\\Drivers-unzipped\\MicrosoftWebDriver.exe");			
			 driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
