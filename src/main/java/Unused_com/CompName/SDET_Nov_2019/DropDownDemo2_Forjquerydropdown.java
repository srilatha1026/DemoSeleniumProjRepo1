package Unused_com.CompName.SDET_Nov_2019;

import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo2_Forjquerydropdown {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//when id or name or anyother tagname not present use the text present in the tag
		
		//click on Other Web-Element in the page
		driver.findElement(By.xpath("//a[text()='Other Web-Elements']")).click();
		
		//this is another example of finding the web element called Selectmenu from the sidebar in the web page
		//in this case id or name or another tag is not present directly to write the xpath
		//so we go for this method
		driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Selectmenu']")).click();
		
		//click on jquerydrop down
		driver.findElement(By.id("number-button")).click();
		//driver.findElement(By.xpath("//ul[@id='number-menu']//div[text()='3']")).click();
		
		//to dynamically select the number from the dd
		String NumbertobeSelected = "5";
		driver.findElement(By.xpath("//ul[@id='number-menu']//div[text()='" + NumbertobeSelected +"']")).click();
		
		//multi-select from the dd web-element
		Select multiSelect=new Select(driver.findElement(By.id("selenium_suite")));
		multiSelect.selectByValue("RC");
		multiSelect.selectByIndex(1);
		//multiSelect.deselectAll();
		multiSelect.deselectByIndex(1);
		
			}

}
