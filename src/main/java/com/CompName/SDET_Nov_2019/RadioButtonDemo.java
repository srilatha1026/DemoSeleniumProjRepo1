package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("file:///E:/dummyProject/app.html"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String righthandDrive="yes";
		
		
		//click on Radiobutton
		
		if(righthandDrive.equals("yes")) {
			//click on yes
			// //input[@id='righthanddriveyes']/following-sibling::span
			driver.findElement(By.xpath("//input[@id='righthanddriveyes']/following-sibling::span")).click();
		}else {
			//click on no
			// //input[@id='righthanddriveyes']/following-sibling::span
			driver.findElement(By.xpath("//input[@id='righthanddriveno']/following-sibling::span")).click();
		}
	
		//check if webelement is displayed on the webpage
		//first find the webelement
	//	WebElement radioYes=driver.findElement(By.xpath("//input[@id='righthanddriveyes']/following-sibling::span"));
	//	System.out.println("Radiobutton is displayed" +radioYes.isDisplayed());
	//	System.out.println("Radiobutton is enabled" + radioYes.isEnabled()); //check if webelement is enabled
		//System.out.println("Radiobutton is selected" + radioYes.isSelected()); //check if radio button is selected
	
		//boolean radioButtonSelectedValue=radioYes.isSelected();
		//if (radioButtonSelectedValue) {
		//do something here
		//}
		
	}
}
		
			
	
