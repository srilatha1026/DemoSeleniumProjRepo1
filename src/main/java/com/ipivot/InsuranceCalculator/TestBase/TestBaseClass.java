package com.ipivot.InsuranceCalculator.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ipivot.InsuranceCalculator.Utilities.PropertyOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	//in order to get the data from PropertyOperations class or to access/call the getPropertyValueByKey(String key)method in the PropertyOperations class so that we fetch requied data we create instance of the class
	PropertyOperations propOps = new PropertyOperations();
	
	
	//reading properties file to check which browser to be launched
	//launching respective browser
	//navigate
	//implicit wait,explicit wait,maximize window
	
//	String browser = "chrome";
//	String url = "www.google.com"; since we are using the browser and url from PropertyOperation class
	WebDriver driver;
	public WebDriver LaunchandNavigateBrowser() throws Exception {
		String browser = propOps.getPropertyValueByKey("browser");
		String url = propOps.getPropertyValueByKey("url");
		
		
		if(browser == null || browser == "") {
			throw new Exception("Browser value not set in properties file");
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
	}else {
		throw new Exception("Browser should be set to chrome,Firefox,or IE in properties File");
	}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
	
	
}
