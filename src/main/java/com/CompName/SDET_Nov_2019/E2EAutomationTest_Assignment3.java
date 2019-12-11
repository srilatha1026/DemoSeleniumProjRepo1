package com.CompName.SDET_Nov_2019;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EAutomationTest_Assignment3 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		//setting the initial set ups for selenium to interact with the required browserdriver and launch the same
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		//Step1: Navaige to URL on Google Chrome:  http://qdpm.net/demo/v9/index.php
		//get the url ,implicitly wait for the page to load , maximise the window
		driver.get("http://qdpm.net/demo/v9/index.php");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Step2: Login with Administrator 
		   //enter the required log in credentials
		   //Email: administrator@localhost.com and //Password: administrator
         driver.findElement(By.xpath("//input[@type='text']")).sendKeys("administrator@localhost.com");
         driver.findElement(By.xpath("//input[@type='password']")).sendKeys("administrator");
          
         //click on Remember me chechk box
         //  driver.findElement(By.xpath("//div[@id='uniform-remember_me']/span")).click();
          
       //click on login button
         driver.findElement(By.xpath("//button[text()='Login ']")).click();

       //Step 3: Verify dashboard title after logged in successfully
          String expectedTitle = "qdPM | Dashboard";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
     // WebElement title = driver.findElement(By.xpath("//title[text()='qdPM | Dashboard']"));
     //title.isDisplayed();
          	
  	  //Step 4:Verify that all options are present on dashboard page
          	boolean isDashboardPresent = driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
          	boolean isProjectsPresent = driver.findElement(By.xpath("//span[text()='Projects']")).isDisplayed();
          	boolean isTasksPresent = driver.findElement(By.xpath("//span[text()='Tasks']")).isDisplayed();
          	boolean isTicketsPresent = driver.findElement(By.xpath("//span[text()='Tickets']")).isDisplayed();
          	boolean isDiscussionsPresent = driver.findElement(By.xpath("//span[text()='Discussions']")).isDisplayed();
          	boolean isReportsPresent = driver.findElement(By.xpath("//span[text()='Reports']")).isDisplayed();
          	boolean isUsersPresent = driver.findElement(By.xpath("//span[text()='Users']")).isDisplayed();
          	boolean isConfigurationPresent = driver.findElement(By.xpath("//span[text()='Configuration']")).isDisplayed();
          	boolean isToolsPresent = driver.findElement(By.xpath("//span[text()='Tools']")).isDisplayed();
          	boolean isqdPMExtendedPresent = driver.findElement(By.xpath("//span[text()='qdPM Extended']")).isDisplayed();
          	
          	Assert.assertEquals(isDashboardPresent, true);
          	Assert.assertEquals(isProjectsPresent, true);
          	Assert.assertEquals(isTasksPresent, true);
          	Assert.assertEquals(isTicketsPresent, true);
          	Assert.assertEquals(isDiscussionsPresent, true);
          	Assert.assertEquals(isReportsPresent, true);
          	Assert.assertEquals(isUsersPresent, true);
          	Assert.assertEquals(isConfigurationPresent, true);
          	Assert.assertEquals(isToolsPresent, true);
          	Assert.assertEquals(isqdPMExtendedPresent, true);
          //Other ways of writing Assertions:
          //	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Projects']")).isDisplayed(), true);
          //	Assert.assertTrue(isDashboardPresent);
          	
          //	Assert.assertEquals("Google", "Gtalk", "message here in case of failure");
          	
  	 //Step 5::  Click on “Add Task” button 
          	driver.findElement(By.xpath("//button[text()='Add Task']")).click();

           // driver.switchTo().activeElement();  
            Thread.sleep(5000);
     //Step 6: Select “Test Project1” from project dropdown list
          	driver.findElement(By.xpath("//select[@id='form_projects_id']")).click();
          	driver.findElement(By.xpath("//select[@id='form_projects_id']/option[text()='Test Project 1']")).click();
          	
   	//Step7: Enter below data Under General tab 
         	driver.findElement(By.xpath("//a[text()='General']")).click();
          //Type: Defects
          	WebElement taskTypedd = driver.findElement(By.xpath("//select[@id='tasks_tasks_type_id']"));
    		Select selectType = new Select(taskTypedd);
    		selectType.selectByVisibleText("Defects (Hourly rate $0.00)");
	
    	  //Name: Your Name
    		WebElement name = driver.findElement(By.xpath("//input[@id='tasks_name']"));
    		name.sendKeys("Srilatha");
        	
    	 //Status: Lost
    		WebElement statusDD =driver.findElement(By.xpath("//select[@id='tasks_tasks_status_id']"));
         	Select statusType = new Select(statusDD);
    		statusType.selectByVisibleText("Lost");
	
    	 //Priority: Low
    		WebElement priorityDD = driver.findElement(By.id("tasks_tasks_priority_id"));
    		Select priority = new Select(priorityDD);
    		priority.selectByValue("3");
    		    		
		//Label: Issue
    		WebElement labelDD = driver.findElement(By.id("tasks_tasks_label_id"));
    		Select label = new Select(labelDD);
    		label.selectByIndex(6);;
        //Assigned to: Select Developer and Manager checkbox.
    		driver.findElement(By.xpath("//label[text()='developer']")).click();
    		driver.findElement(By.xpath("//label[text()='manager']")).click();
    		
        //Created By: Manager
    		WebElement createdByDD = driver.findElement(By.id("tasks_created_by"));
    		Select createdBy = new Select(createdByDD);
    		createdBy.selectByVisibleText("manager");
    		
    	//Step8: Switch to time tab and enter below data.
    		driver.findElement(By.linkText("Time")).click();
    		
    		//enter Estimated time: 11
    			driver.findElement(By.id("tasks_estimated_time")).sendKeys("11");
			//Start Date: 	2019-12-27 and 		End Date:     2019-12-31
	    		driver.findElement(By.id("tasks_start_date")).sendKeys("2019-12-27");
	    		driver.findElement(By.id("tasks_due_date")).sendKeys("2019-12-31");
    		//enter Progress is 20%
	    		WebElement progressDD = driver.findElement(By.id("tasks_progress"));
	    		Select progress = new Select(progressDD);
	    		progress.selectByValue("20");
    		
    	//Step9: Switch to attachment tab. 
	    		WebElement mouseHoverAttach = driver.findElement(By.xpath("//a[text()='Attachments']"));
	    		Actions act = new Actions(driver);
	          	act.moveToElement(mouseHoverAttach).click().build().perform();
	          	
	       //upload an attachment 
	          	//using send keys
	          	//driver.findElement(By.xpath("//input[@type='file']//preceding-sibling::input[@id='uploadify_file_upload']//parent::div[@id='uploadifive-uploadify_file_upload']")).sendKeys("C:\\Users\\Simlat\\Desktop\\lats_iphone 133.JPG");
	          	
          	//using robot class
	          	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	            driver.findElement(By.xpath("//input[@type='file']//parent::div[@id='uploadifive-uploadify_file_upload']")).click();;
	            StringSelection ss = new StringSelection("C:\\Users\\Simlat\\Desktop\\IMG_0801.JPG");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
				
				Thread.sleep(5000);
				
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
          
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
          
			Thread.sleep(9000);
			
			//Save button
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			Thread.sleep(5000);
						
	  //Step 10: Logout of application 
			//click on admin at the top right corner
			driver.findElement(By.xpath("//li[@class='dropdown user']/child::a")).click();
			//click on log-off
//			driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/login/logoff']")).click();
			driver.findElement(By.xpath("//*[text()=' Logoff']//parent::a")).click();
			
	  //Step 11: Once logged out, verify the page title (using assertion, refer link provided in step4)	
		 String actualtitleOfPage = driver.getTitle();
		 String expectedtitleOfPage = "qdPM | Login";
		 Assert.assertEquals(actualtitleOfPage, expectedtitleOfPage, "Titles Matching");
		 
	 //Step 12: Login again with credentials given in step2.
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("administrator@localhost.com");
         driver.findElement(By.xpath("//input[@type='password']")).sendKeys("administrator");
         driver.findElement(By.xpath("//button[text()='Login ']")).click();
		 Thread.sleep(2000);
		 
	 //Step 13: Click on Tasks (In the left side list items) & click on “View All” option.
		 driver.findElement(By.xpath("//span[text()='Tasks']")).click();
		 driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/tasks']/span[text()='View All']")).click();
		 
	//Step14: Do mousehover on Search field 
		 WebElement searchField = driver.findElement(By.xpath("//ul/li[@id='yui-gen1']"));
		 Actions movemouseonSearch = new Actions(driver);
		 movemouseonSearch.moveToElement(searchField).build().perform();
		 
	//Step15: Enter your name (used in step 7) in search box and then click on Search button.
		 WebElement searchText = driver.findElement(By.xpath("//td/input[@id='search_keywords']"));
		 searchText.sendKeys("Srilatha");
		 //click on Search button
		 WebElement searchButton = driver.findElement(By.xpath("//td/input[@class='btn btn-default']"));
		 searchButton.click();
		 
	//Step16: Verify the search result against those entered in step 7 and step 8
		 //Label: Issue 
//		boolean islabelDisplayed = driver.findElement(By.xpath("//table//tr/td[text()='Issue']")).isDisplayed();
//		Assert.assertEquals(islabelDisplayed, true);
		 String labelData = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
		 Assert.assertEquals(labelData, "Issue", "The names do not match");
	
		 //name
//		 boolean actualNameDisplayed = driver.findElement(By.xpath("//a[text()='Srilatha']")).isDisplayed();
//		 Assert.assertEquals(actualNameDisplayed, true);
		 String nameData = driver.findElement(By.xpath("//table/tbody/tr/td[5]")).getText();
		 Assert.assertEquals(nameData, "Srilatha", "The names do not match");
		 
		 
		 //Status: Lost
//		 boolean actualStatusDisplayed = driver.findElement(By.xpath("//td[text()='Lost']")).isDisplayed();
//		 Assert.assertEquals(actualStatusDisplayed, true);
		 String statusData = driver.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
		 Assert.assertEquals(statusData, "Lost", "The names do not match");
		 
		 //assigned to
		 String assignedToData = driver.findElement(By.xpath("//table/tbody/tr/td[7]")).getText();
		 System.out.println(assignedToData);
		 System.out.println("developer\r\n" + "manager");
		 Assert.assertEquals(assignedToData.toString(), "developer\r\n" + "manager", "The names do not match");
		
		 
		 //Est time
		 String estTimeData = driver.findElement(By.xpath("//table/tbody/tr/td[8]")).getText();
		 Assert.assertEquals(estTimeData, "11", "The time do not match");
//	//Step17:Clicking on delete button
//		 driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[@class='btn btn-default btn-xs purple']")).click();
//		 
//	//Step18: confirmation in Alert. So switch to that alert and accept it.	 
//		 Alert al =driver.switchTo().alert();
//		 al.accept();
//		 
//	//Step19: Verify that user is deleted from system. 
//		 WebElement searchField1 = driver.findElement(By.xpath("//div[@id='search_menu']"));
//		 Actions movemouseonSearch1 = new Actions(driver);
//		 movemouseonSearch1.moveToElement(searchField1).build().perform();
//		 
//		 WebElement searchText1 = driver.findElement(By.xpath("//td/input[@id='search_keywords']"));
//		 searchText1.sendKeys("Srilatha");
//		 
//		 WebElement searchButton1 = driver.findElement(By.xpath("//td/input[@class='btn btn-default']"));
//		 searchButton1.click();
//		 
//		 String actualTableContents = driver.findElement(By.xpath("//td[text()='No Records Found']")).getText();
//		 String expectedTableContents = "No Records Found";
//		 Assert.assertEquals(actualTableContents, expectedTableContents);
//		 
//	//Step20: Logout of application & close browser.
//		 	//Logging off
//		//click on admin at the top right corner
//			driver.findElement(By.xpath("//a[@href='#']")).click();
//		//click on log-off
//			driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/login/logoff']")).click();
//			
//		Thread.sleep(3000);
//			//Close browser
//			driver.quit();
		
		 
	 
			
	}

}
