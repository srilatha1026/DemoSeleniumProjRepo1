package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithHtmlPage_LoginTest {

	public static void main(String[] args) throws InterruptedException {
	
		//Launch the browser -->can be chrome,firefox
		//use ChromeDriver class to launch chrome browser
		//selenium cannot directly talk with any browser.
		//so download chromeDriver.exe
		//so we need to do setproperty inorder to fetch the browser
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Simlat\\Dev\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demowebshop.tricentis.com/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//how to interact with webelement

		// First way to find a webelement using ABSOLUTE Xpath and then click on it using click method as in line36
		//WebElement loginLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		//loginLink.click();
		//Similar way to find the webelement using RELATIVE Xpath
		driver.findElement(By.xpath("//a[@class=\'ico-login']")).click();
		
		
		//second way of writing the code for both finding the webelement and making it to perform the required action .in this case it is inputting some values using sendKeys() method
		driver.findElement(By.id("Email")).sendKeys("simlat21@testmail.com");
		driver.findElement(By.name("Password")).sendKeys("123454567");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
		
		//Thread.sleep(8000);
		//driver.close();
			}

}
