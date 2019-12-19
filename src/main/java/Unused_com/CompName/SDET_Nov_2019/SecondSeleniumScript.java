package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSeleniumScript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Simlat\\Dev\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://sites.google.com/a/chromium.org/chromedriver/downloads");
		
		//selenium needs to wait until the browser is open before it executes the secondstep of verifying the page title in our example.
		//so we need to synchronise the time.
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//we needto maximise the browser window if it is not maximze mode
		 driver.manage().window().maximize();
		 
		 // wait for 3seconds before refreshing the page
		 Thread.sleep(3000);
		//refresh
		 driver.navigate().refresh();
		 
		 Thread.sleep(3000);
		// navigate backward
		 
		 Thread.sleep(3000);
		 driver.navigate().back();
		
		 Thread.sleep(3000);
		 //navigate forward 
		 driver.navigate().forward();
		 
		 Thread.sleep(3000);
		 //close driver
		 driver.close();
	}
	

}
