package com.CompName.SDET_Nov_2019;

import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/AlertMessage/index.html"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//click on generate alert button
		driver.findElement(By.xpath("//button[text()='Generate Confirm Box']")).click();
		
		//handle Alert
		//Switch from web-page to alert
		Alert al =driver.switchTo().alert();
		Thread.sleep(3000);
		//al.accept();	//Accept Alert
		
		//Read the Text in the alertbox
		String AlertText = al.getText();
		System.out.println(AlertText);
		
		//Dismiss Alert
		al.dismiss(); // cancel alert
		
		//Read AlertText
		String message = driver.findElement(By.id("demo")).getText();
		System.out.println(message);
		
		//EnterVAlue in Alert
		driver.findElement(By.id("promptBox")).click();
		//Switch from web-page to alert
				Alert al1 =driver.switchTo().alert();
				al1.sendKeys("Selenium");
				Thread.sleep(3000);
		//Accept Alert
				al1.accept();	
			}

}
