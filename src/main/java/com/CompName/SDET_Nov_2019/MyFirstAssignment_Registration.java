package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstAssignment_Registration {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. //that is open URL
		driver.get("http://services.smartbear.com/samples/TestComplete14/smartstore/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Click on Log-in link
		driver.findElement(By.xpath("//*[@id=\"menubar-my-account\"]/div/a")).click();
		
		//click on Register button
		driver.findElement(By.xpath("//a[@class='btn btn-warning btn-lg btn-block register-button']")).click();
		
		//first find the webelement gender
		
		//click on Gender radio button as male
		String genderMaleButton = "Male";
		if(genderMaleButton.equals("Male")) {
						
			driver.findElement(By.id("gender-male")).click();
		}else {
			driver.findElement(By.id("gender-female")).click();
		}
		
		//Enter First-name and LastName
		//driver.findElement(By.id("FirstName")).sendKeys("John");
		driver.findElement(By.id("FirstName")).sendKeys("Johnson");
		driver.findElement(By.id("LastName")).sendKeys("Hauge");
		
		//Enter DOB as 13 Aug 1989
		WebElement dayDropDown=driver.findElement(By.name("DateOfBirthDay"));
		//Select Date
		Select selectDate=new Select(dayDropDown);
		selectDate.selectByVisibleText("14");
		//Select Month
		WebElement monthDropDown=driver.findElement(By.name("DateOfBirthMonth"));
		Select selectMonth=new Select(monthDropDown);
		selectMonth.selectByVisibleText("August");
		//Select Year
		WebElement yearDropDown=driver.findElement(By.name("DateOfBirthYear"));
		Select selectYear=new Select(yearDropDown);
		selectYear.selectByVisibleText("1989");
		
		
		//Enter Email address and username
		//driver.findElement(By.id("Email")).sendKeys("simlat21@gmail.com");
		driver.findElement(By.id("Email")).sendKeys("simhampn@gmail.com");
		//driver.findElement(By.id("Username")).sendKeys("Simlat");
		driver.findElement(By.id("Username")).sendKeys("Simlat21");
		
		//Password entry and its confirmation
		//driver.findElement(By.id("Password")).sendKeys("Automation2019");
		//driver.findElement(By.id("ConfirmPassword")).sendKeys("Automation2019");
		driver.findElement(By.id("Password")).sendKeys("Automation@2019");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Automation@2019");
		
		//company name
		driver.findElement(By.id("Company")).sendKeys("ThinkThank1");
		
		//Select Newsletter checkbox
		driver.findElement(By.id("Newsletter")).click();
		
		//Click on Registerbutton
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-lg\"]")).click();
		
	    //Verify Registrationsuccess page
		
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div[2]/p"));
		
		//Click on continue
		driver.findElement(By.xpath("//a[@class='btn btn-secondary register-continue-button']")).click();
		
		Thread.sleep(3000);
		driver.close();
	}
}
		
			
	
