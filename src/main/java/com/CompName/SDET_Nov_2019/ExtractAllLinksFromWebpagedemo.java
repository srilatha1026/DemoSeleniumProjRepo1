package com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtractAllLinksFromWebpagedemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//to extract all the links
		driver.findElement(By.xpath("//a[text()='Other Web-Elements']")).click();
		
		//all links start with tag name <a>
		//store in the list --.java collection
		
		//multiple web elements ie list of web elements in a bucket
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));// just contain the web elements
		
		//extract it
		//for each loop
		for (WebElement webLink : allLinks) {
			System.out.println("the list of links using for each loop is:" + webLink.getAttribute("href"));
			
		}
		
		//real-time to check if all links are working using HttpURLConnection
		
		
		
	}

}
