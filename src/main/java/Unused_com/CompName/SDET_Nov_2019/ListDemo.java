package Unused_com.CompName.SDET_Nov_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListDemo {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
//		WebDriver driver = new ChromeDriver();
//		
//		//Navigate to the desired appln. /that is open URL
//		driver.get("http://demo.automationtalks.com/"); //get method used to open the url
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		
//		//array collection of similar data type
//		String[] str = new String[5];
		
		//multiple things,should be give the size of array. becomes difficult during runtime. so not preferred
		
		// new vwersion of expandable or dynamic array is called list
		//List is an interface coming from java util
		List<String> l1 = new ArrayList<String>(); 
		 l1.add("one");
		 l1.add("two");
		 
		 //retrieve the list
		 l1.get(0);
		 int ALsize =l1.size();
		 System.out.println("ArrayList element :  " + l1);
		 System.out.println("Size of the list: "+ ALsize);
		
		 String[] listToarray = l1.toArray(new String[2]);
			System.out.println("Array length: "+listToarray.length);
		//	for(String ArrayEle:listToarray) {
				for(int i =1;i<listToarray.length;i++) {
			System.out.println("Array elements: "+ listToarray[0]);
			}
			//}
	}
			
			

}
