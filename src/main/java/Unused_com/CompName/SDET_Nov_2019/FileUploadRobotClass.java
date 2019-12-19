package com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class FileUploadRobotClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); //instead of setProperty() methodused above without maven
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the desired appln. /that is open URL
		driver.get("http://demo.automationtalks.com/index.html"); //get method used to open the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Select the MAKE dropdown in the webpage and //Select an option from the dropdown
		WebElement makeDD=driver.findElement(By.id("make"));
		//WebElement makeDD = driver.findElement(By.xpath("//select[@id='make']"));
		
		Select selectMakeOption = new Select(makeDD);
		selectMakeOption.selectByVisibleText("Honda");
		//selectMakeOption.selectByValue("Honda");
		
		//Select Model
		WebElement ModelDD = driver.findElement(By.id("model"));
		Select Model = new Select(ModelDD) ;
		Model.selectByValue("Motorcycle");
		
		//Select CylinderCapacity
		driver.findElement(By.xpath("//input[@id = 'cylindercapacity']")).sendKeys("876");
		
		
		//Enter Engine Performance
		driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys("544");
		
		//Date of MAnufacture
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys("12/10/2018");
		//How to check if the dateselected is less than or equals current date
		
		//Select No.Of seats
		WebElement selectseatsdd=driver.findElement(By.id("numberofseats"));
		Select selectNoOfSeats= new Select(selectseatsdd);
		selectNoOfSeats.selectByValue("8");
		
		//Click RadioButton RightHAndDrive
		//String rightHandDriveButton ="Yes";
		//if(rightHandDriveButton.equals("Yes")) {
						
		//	driver.findElement(By.xpath("//input[@id='righthanddriveyes']")).click();
		//}else {
		//	driver.findElement(By.xpath("//input[@id='righthanddriveno']")).click();
		//}
		
		//input PAyload
		driver.findElement(By.id("payload")).sendKeys("234");
		
		//input Totalweight
		driver.findElement(By.id("totalweight")).sendKeys("345");
		
		//Select No.Of seats2
		WebElement selectseatsdd2=driver.findElement(By.id("numberofseatsmotorcycle"));
		Select selectNoOfSeats2= new Select(selectseatsdd2);
		selectNoOfSeats2.selectByValue("2");
		
		//Select FuelType
		WebElement selectFueldd = driver.findElement(By.xpath("//select[@id='fuel']"));
		Select selectFuelType = new Select(selectFueldd);
		selectFuelType.selectByValue("Petrol");
		
		//ListPrice
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("34556");
		
		//AnnualMilegae
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("26349");
		
		//click next button
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();
		
		//Verification of PAge title as Fill Insurant Data
		String ExpectedPageTitle = "Fill Insurant Data";
		String CurrentPageTitle = driver.getTitle();
		if(CurrentPageTitle.equals(ExpectedPageTitle)){
			System.out.println("The Page titles are verified and matching ");
			}
	
	// Fill Insurant Page
		//Enter Firstname and
		driver.findElement(By.id("firstname")).sendKeys("Simlat");
		//Enter Last name 
		driver.findElement(By.id("lastname")).sendKeys("siripul");
		
		//Enter DOB
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("10/18/1984");
		
		//Radiobutton Gender
		String genderFemaleButton = "Female";
		if(genderFemaleButton.equals("Female")) {
			driver.findElement(By.xpath("//input[@id=\"genderfemale\"]/following-sibling::span")).click();
		}else {
			driver.findElement(By.xpath("//input[@id=\"gendermale\"]/following-sibling::span")).click();
		}
		//Select Country
		WebElement countryDD = driver.findElement(By.xpath("//select[@id='country']"));
		Select countryID = new Select(countryDD);
		countryID.selectByValue("Armenia");
		
		//Enter zipcode
		driver.findElement(By.id("zipcode")).sendKeys("123456");
		
		//Enter Occupation
		WebElement OccupationDD = driver.findElement(By.xpath("//select[@id='occupation']"));
		Select occupationVal= new Select(OccupationDD);
		occupationVal.selectByVisibleText("Selfemployed");
		
		//Hobbies Checkbox
		driver.findElement(By.xpath("//input[@id=\"skydiving\"]/following-sibling::span")).click();
		driver.findElement(By.xpath("//input[@id=\"cliffdiving\"]/following-sibling::span")).click();
		driver.findElement(By.xpath("//input[@id=\"other\"]/following-sibling::span")).click();
		
		
		//Upload Picture using sendkeys method
		//driver.findElement(By.id("")).sendKeys(imagepath);
		//Upload Picture using RobotClass
		driver.findElement(By.id("open")).click();
		
		
		// click next button
		 driver.findElement(By.xpath("//button[@id='nextenterproductdata']")).click();
		
		//Verification of PAge title as Fill Product Data
		   String ExpectedPageTitle2 = "Fill Product Data";
		   String CurrentPageTitle2 = driver.getTitle();
		    if(CurrentPageTitle2.equals(ExpectedPageTitle2)){
			   System.out.println("The Page2 titles are verified and matching ");
			  }else {
				  System.out.println("The Page2 titles are verified and not matching ");
			  }
		
		//Fill Product Data
		    //Start Date
		    
		    // driver.findElement(By.xpath("//button[@id='openstartdatecalender']")).click();
		    // String todayDate = "11/27/2019";
		       driver.findElement(By.id("startdate")).sendKeys("02/29/2020");
		    
		    
		    //Enter InsuranceSum
		      WebElement insuranceSumDD = driver.findElement(By.xpath("//select[@id='insurancesum']"));
		      Select insuranceSumValue = new Select(insuranceSumDD);
		      insuranceSumValue.selectByValue("20000000");
		      
		     //String NumbertobeSelected = "20000000";
		      //driver.findElement(By.xpath("//select[@id='insurancesum']//option[text()='"+NumbertobeSelected +"']")).click();
		
		
		    //Select MeritRating
		      
		      WebElement meritRatingDD = driver.findElement(By.id("meritrating"));
		      Select selectMeritRating = new Select(meritRatingDD);
		      selectMeritRating.selectByValue("Bonus 9");
		    
		    //DamageInsurance
		      
		      WebElement damageIsuranceDD = driver.findElement(By.id("damageinsurance"));
		      Select damageInsurance = new Select(damageIsuranceDD);
		      damageInsurance.selectByVisibleText("Full Coverage");
		      
		    //Optional Product 
		      driver.findElement(By.xpath("//input[@id=\"EuroProtection\"]/following-sibling::span")).click();
		      
		    //Courtesy Car
		      WebElement CourtesyCarDD = driver.findElement(By.xpath("//select[@id='courtesycar']"));
		      Select CourtesyCar = new Select(CourtesyCarDD);
		      CourtesyCar.selectByVisibleText("Yes");
		      
	      Thread.sleep(3000);
			// click next button
			   driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();
				
			//Verification of PAge title as Choose Price Option
				String ExpectedPageTitle3 = "Choose Price Option";
				String CurrentPageTitle3 = driver.getTitle();
				    if(CurrentPageTitle3.equals(ExpectedPageTitle3)){
					   System.out.println("The Page3 titles are verified and matching ");
					  }else {
						  System.out.println("The Page3 titles are verified and not matching ");
					  }
				    
		    //We are now in Choose Price Option Table
		    
		      //Select Platinum Option
				    driver.findElement(By.xpath("//input[@id='selectplatinum']/following-sibling::span")).click();
				    
		    
				 // click next button
					   driver.findElement(By.xpath("//button[@id='nextsendquote']")).click();
				    
	} 

}
