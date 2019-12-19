package Unused_com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageTitleandCurrentURL {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//verify pageTitle
		String expectedPageTitle = "Facebook";
		String currentpageTitle=driver.getTitle();
		if(currentpageTitle.equals(expectedPageTitle)) {
			System.out.println("title matches");
		}else {
			System.out.println("title not matches");
			  }
		
		//current url
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is" + currentURL);

	}

}
