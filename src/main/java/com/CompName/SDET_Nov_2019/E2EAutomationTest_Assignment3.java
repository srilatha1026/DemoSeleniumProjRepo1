package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EAutomationTest_Assignment3 {

	public static void main(String[] args) {
		
		//setting the initial set ups for selenium to interact with the required browserdriver and launch the same
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//get the url ,implicitly wait for the page to load , maximise the window
		driver.get("http://qdpm.net/demo/v9/index.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//enter the required log in credentials
		//Email: administrator@localhost.com and //Password: administrator
          driver.findElement(By.xpath("//input[@type='text']")).sendKeys("administrator@localhost.com");
          driver.findElement(By.xpath("//input[@type='password']")).sendKeys("administrator");
          
       //click on Remember me chechk box
       //  driver.findElement(By.xpath("//div[@id='uniform-remember_me']/span")).click();
          
       //click on login button
          driver.findElement(By.xpath("//button[text()='Login ']")).click();

//   //Step 3: Verify dashboard title after logged in successfully

          WebElement title = driver.findElement(By.xpath("//title[text()='qdPM | Dashboard']"));
          title.isDisplayed();

      
          
          
          
          
          
          
          
          
          
          
          
          
	}

	
}
