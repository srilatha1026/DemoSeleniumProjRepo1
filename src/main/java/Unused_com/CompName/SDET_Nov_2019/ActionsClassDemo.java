package Unused_com.CompName.SDET_Nov_2019;

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

public class ActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/tooltip-and-double-click/index.html"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//find the webelement that needs some actionto be performed
		WebElement mouseHover = driver.findElement(By.id("tooltipDemo"));
		
		//Actions Class
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();
		
		WebElement toolTip = driver.findElement(By.xpath("//div[@id='tooltipDemo']/span[text()='We ask for your age only for statistical purposes.']"));
		System.out.println("tooltip displayed is:" + toolTip.getText());
		
		//doubleclick action
		WebElement dblclckbtn = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(dblclckbtn).build().perform();
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		Thread.sleep(3000);
		
		//rightclick btn
		WebElement rghtclckbtn = driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rghtclckbtn).build().perform();
		
		//navigate to another page
		driver.navigate().to("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/droppable/index.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions act2 = new Actions(driver); //here act2 is created and used inorder to create action class object for the current url.So we dont use act object from previous
		act2.dragAndDrop(draggable, droppable).build().perform();
		
		//keyboard actions using action class
		act2.keyDown(Keys.F5);
		act2.keyUp(Keys.F5);
	}

}
