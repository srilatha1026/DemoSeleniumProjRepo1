package com.CompName.SDET_Nov_2019;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClassDemo2 {

	public static void main(String[] args) throws InterruptedException, AWTException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//click next button on first page and go to next page for file upload
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();
		
		//this is first way to upload file when web-element type=file is present
		//inspect picture field and upload a file
		//driver.findElement(By.id("picturecontainer")).sendKeys("C:\\Users\\Simlat\\Desktop\\lats_iphone 133.JPG");
				
		//file upload dialog box
		//selenium automates only browser.the dialog box opened is windows
		//second way using robot class
				driver.findElement(By.id("open")).click(); //clickson open button
		//step 1:take image location to clip board =ctrl+c
				StringSelection ss = new StringSelection("C:\\Users\\Simlat\\Desktop\\lats_iphone 133.JPG");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //toolkit is a class which is used anytime we need to get contents to clipboard
		//step 2: paste with ctrl+v from robot class
				
				Robot rb = new Robot();
				
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				
		//step 3: hit enter using robot class

				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
