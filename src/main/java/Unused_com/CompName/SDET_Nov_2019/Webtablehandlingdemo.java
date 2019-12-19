package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtablehandlingdemo {

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
		//to enter vehicle data
		//insurant data
		//enter product data
		
		//webtable is data present in tabular format.it can be identified as <table> tagname
		//do not use "id" attribute to write code  
		
		//each <tr> tag contains different no of cells called table data represented by <td> tag.it is the actual data 
		
	  //verify if silverplanprice
		String actualSilverPrice= driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td[2]")).getText();
		String actualGoldPrice= driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td[3]")).getText();
		String actualPlatinumPrice= driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td[4]")).getText();
		System.out.println("Actual Silver Price is:" + actualSilverPrice);
		System.out.println("Actual Gold Price is:" + actualGoldPrice);
		System.out.println("Actual Platinum Price is:" + actualPlatinumPrice);
		
		for(int i=2;i<=5;i++) {
			String Price = driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td[" + i + "]")).getText();
			System.out.println("PriceRow :" + Price );
		}
		
		//String expectedSilverPlanPrice="284.00";
		//String expectedGoldPlanPrice="836.00";
		//String expectedPlatinumPlanPrice="1549.00";
		
		//find total no of rows in the table FINDELEMENTS
		int TotalRows = driver.findElements(By.xpath("//table[@id='priceTable']/tbody/tr")).size();
		System.out.println("Total no of rows:" + TotalRows);
		
		//find total no of columns in the table
		int TotalColumns = driver.findElements(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td")).size();
		System.out.println("Total no of columns:" + TotalColumns);
		
	
		
		
		
	}

}
