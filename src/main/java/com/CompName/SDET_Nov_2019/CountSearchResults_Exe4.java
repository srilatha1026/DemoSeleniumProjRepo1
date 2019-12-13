package com.CompName.SDET_Nov_2019;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountSearchResults_Exe4 {

	public static void main(String[] args) throws AWTException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		//Search for text box and enter "site:automationtalks.com"
		  WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		  searchBox.sendKeys("site:automationtalks.com");

		  Robot rb = new Robot();
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
		  
	   //Search result in page 1
		 
		  List<WebElement> allLinks = driver.findElements(By.xpath("//span[@class='S3Uucc']"));
		  int size1= allLinks.size();
		   
		  for(WebElement searchLinks : allLinks) {
			  System.out.println("Search Results in Page1 :" + searchLinks.getText());
		  }
		  System.out.println("No.of links in the Page1: "+  size1);
	  //Click on next if it is enabled
		  
		  WebElement nextButton = driver.findElement(By.xpath("//table[@id='nav']/tbody/tr[1]/td[12]/a[@id='pnnext']//span[text()='Next']"));
		  nextButton.click();
		 
		  //Search result in page 2
			  List<WebElement> allLinks1 = driver.findElements(By.xpath("//span[@class='S3Uucc']"));
			  int size2= allLinks1.size();
			  for(WebElement searchLinks1 : allLinks1) {
				  System.out.println("Search Results in Page2: " + searchLinks1.getText());
				  
			          }	 
			  System.out.println("No.of links in the Page2: "+ size2); 
		  //click on next button
			  driver.findElement(By.xpath("//span[text()='Next']")).click();
			  
			  
			  
			  
			  int totalSize = size1+size2;	
			  System.out.println("Total no of search result is = " + totalSize);
			  
			  
	}
}
