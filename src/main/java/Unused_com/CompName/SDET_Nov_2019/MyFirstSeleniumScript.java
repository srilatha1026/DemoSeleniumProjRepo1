package Unused_com.CompName.SDET_Nov_2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumScript {

	public static void main(String[] args) {
	
		//Launch the browser -->can be chrome,firefox
		//use ChromeDriver class to launch chrome browser
		//selenium cannot directly talk with any browser.
		//so download chromeDriver.exe
		//so we need to do setproperty inorder to fetch the browser
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Simlat\\Dev\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup(); //instead of set property methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("https://www.google.com/"); //get method used to open the url
		//driver.navigate().to("url");
		
		//start actual application testing -- > eg.verify page title
		//get the page title of the web alppication to be tested //verify the page title
		String aTitle = driver.getTitle(); //actual title
			 
		//expected title
		String eTitle = "Google";
		
		// use equals() method to compare two strings and not == sign
		//if (aTitle == eTitle) not to be used instead follow the below line
		
		if (aTitle.equals(eTitle)) {
			System.out.println("Titles are matching");
		}else {
			System.out.println("Titles are not matching");
		}
		//closing browser
		driver.close();
	}

}
