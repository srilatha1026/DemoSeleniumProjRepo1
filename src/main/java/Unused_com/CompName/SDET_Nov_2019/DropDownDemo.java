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

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Dropdowns are coded using the <select> tag
		//few times DDsare coded using <div> tag
		
		
		// select the webelement Make in the webpage
		WebElement makeDD=driver.findElement(By.id("make"));
		//Select  the value from the dropdown
		Select selectMakeDD=new Select(makeDD);
		selectMakeDD.selectByVisibleText("BMW");
		
		//to get the list of all values from makedd
		List<WebElement> listOfOptions =  selectMakeDD.getOptions();
		System.out.println("Total no of items in the list is " + listOfOptions.size());
		
		//listOfOptions contains webelemetns. doent contain text directly
		for(int i=0;i<listOfOptions.size();i++) {
			System.out.println("The items in the list are " + listOfOptions.get(i).getText());
		}
		
		
		
		
			}

}
