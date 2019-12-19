package Unused_com.CompName.SDET_Nov_2019;

import java.awt.AWTException;
import java.util.ArrayList;
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
		  driver.findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input")).click();

		  
	   //Search result in page 1
		 
		  List<WebElement> allLinks = driver.findElements(By.xpath("//div[@id='search']//h3"));
		  int size1= allLinks.size();
		   
		  for(WebElement searchLinks : allLinks) {
			  String linksText= searchLinks.getText();
			  System.out.println("Search Results in Page1 :" + linksText);
		  }
			  System.out.println("No.of links in the Page1: "+ size1 );
			   
		  
	  //Click on next if it is displayed
		  
		 Boolean nextButtonDisplayed = driver.findElement(By.xpath("//table[@id='nav']/tbody/tr[1]/td[12]/a[@id='pnnext']//span[text()='Next']")).isDisplayed();
		  	 while(nextButtonDisplayed) {
			  driver.findElement(By.xpath("//table[@id='nav']/tbody/tr[1]/td[12]/a[@id='pnnext']//span[text()='Next']")).click();
			  List<WebElement> allLinks1 = driver.findElements(By.xpath("//div[@id='search']//h3"));	
			  int size= allLinks1.size();
			  
			  for(WebElement searchLinks1 : allLinks1) {
		  	    	System.out.println("Search Results in Page:"+ searchLinks1.getText());
		  	    				  }
			  System.out.println("No.of links in the Page: "+ size );
		  	 }
			  
			  
	}
}
