package com.CompName.SDET_Nov_2019;

import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWaitsDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/WebDriverWait%20Demo/practice/wait.html"); //get method used to open the url
		//IMPILICIT WAIT
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//PAGELOADTIME-OUT
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Click on alert button demo
		driver.findElement(By.id("alert")).click();
		
		//how to use explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		//to enter or change text in textbox after 10sec
		driver.findElement(By.id("populate-text")).click();;
		wait.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));
				
		//to wait explicitly for hidden button to appear after 10 sec
		driver.findElement(By.id("display-other-button")).click();
		WebElement hiddenButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hidden")));
		//hiddenButton.click();
		
		//to wait until button is enabled
		driver.findElement(By.id("enable-button")).click();
		
		WebElement enabledButton= driver.findElement(By.id("disable"));
    	wait.until(ExpectedConditions.elementToBeClickable(enabledButton));
	   	//enabledButton.click();
		
    	//to click on check-box in 10sec
    	driver.findElement(By.id("checkbox")).click();
    	WebElement oncheckBox= driver.findElement(By.xpath("//input[@id='ch']"));
    	wait.until(ExpectedConditions.elementToBeClickable(oncheckBox));
    	//oncheckBox.click();
		
		
		
			}

}
