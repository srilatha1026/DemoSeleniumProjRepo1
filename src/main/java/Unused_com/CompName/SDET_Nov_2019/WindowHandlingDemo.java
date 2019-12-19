package com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.Set;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/automation-practice-switch-windows/index.html"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//click on "New Browser Tab"
		 driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		
		//send focus of the driver  to the new window inorder to type something in its text box
		  
		  String parentWindow = driver.getWindowHandle(); //WindowHandle
		  System.out.println("Parent Window is" + parentWindow );
		  
		  Set<String> setOfWindows = driver.getWindowHandles(); //WindowHandles
		  System.out.println("Set of Windows" + setOfWindows );
		  String childWindow = null;
		
		  //switching to child window
		  for (String st : setOfWindows) {
			  //check if my window id is parent window
			  if(!st.equals(parentWindow)) {
			  childWindow = st;}
			//System.out.println("child window is" + st);
			  }
		 driver.switchTo().window(childWindow); //Switched to child window
		 
		  
		//go to new browser tab  and enter something in the textbox
		 driver.findElement(By.name("q")).sendKeys("Selenium");
		  Thread.sleep(3000);
		
		 //come back to parent window 
		 driver.switchTo().window(parentWindow);
		 String textFromParentWindow = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		 System.out.println("Text from parent window is:"  + textFromParentWindow );
			
		 driver.close(); //close the window on which driver has focus currently
		 //driver.quit(); //closes all the windows launched by driver instance
			
	}

}
