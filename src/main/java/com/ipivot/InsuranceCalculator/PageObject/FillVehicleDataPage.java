package com.ipivot.InsuranceCalculator.PageObject;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ipivot.InsuranceCalculator.Utilities.CommonMethods;

public class FillVehicleDataPage {
	CommonMethods cm =new CommonMethods(); 
	
	//Page Factory
	@FindBy(id="make")
	WebElement dd_make;
	
	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_CylinderCapacity;
	
	@FindBy(xpath="//input[@id='engineperformance']")
	WebElement txt_engineperformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;
	
	@FindBy(xpath="//select[@id='numberofseats']")
	WebElement sel_noOfSeats;
		
	@FindBy(xpath="//input[@name='Right Hand Drive']/parent::label")
	List<WebElement> rdbtn_isRightHandDrive;
		
	@FindBy(xpath="//select[@id='numberofseatsmotorcycle']")
	WebElement sel_numberofseatsmotorcycle;
	
	@FindBy(xpath="//select[@id='fuel']")
	WebElement sel_fuelType;
	
	@FindBy(id="payload")
	WebElement txt_payload;
	
	@FindBy(id="totalweight")
	WebElement txt_totalweight;
	
	@FindBy(id="listprice")
	WebElement txt_listprice;
	
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	
	@FindBy(name="Next (Enter Insurant Data)")
	WebElement btn_Next;
	
	//Initialize webelements from this page with driver
	//constructor of current class,use PageFactory class to initialize the web elements
	
	public FillVehicleDataPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	
	public void FillActualVehicleData(Map m) {
		//create an obj for drop-down
//		Select selectmake= new Select(dd_make);
//		selectmake.selectByVisibleText("bmw");
		// these two lines of selecting items from a drop-down is recurring across the project.
		//So create a common methods class and in it we create all the methods or functionalities that are common across and so that we can call it whereever reqd in the project 
		//once the common method is created do the following:
		
		cm.selectValueFromDropDown(dd_make, m.get("Vehicle_Make").toString());
		cm.selectValueFromDropDown(dd_model,  m.get("Vehicle_Model").toString());
		txt_CylinderCapacity.sendKeys(m.get("Vehicle_CylinderCapacity").toString());
		txt_engineperformance.sendKeys(m.get("Vehicle_Enging Performance").toString());
		date_dateofmanufacture.sendKeys(m.get("Vehicle_Date of Manufacture").toString());
		cm.selectValueFromDropDown(sel_noOfSeats, m.get("Vehicle_No of Seats").toString());
		//for radiobutton common method to be created cos it is a recurring functionality in the other pge in the project
		cm.selectRadioButtonValue(rdbtn_isRightHandDrive, m.get("Vehicle_RightHandDrive").toString());
		
		cm.selectValueFromDropDown(sel_numberofseatsmotorcycle, m.get("Vehicle_No of Seats_motorcycle").toString());
		cm.selectValueFromDropDown(sel_fuelType, m.get("Vehicle_Fuel Type").toString());
		txt_payload.sendKeys(m.get("Vehicle_PayLoad").toString());
		txt_totalweight.sendKeys(m.get("Vehicle_Total Weight").toString());
		txt_listprice.sendKeys(m.get("Vehicle_List Price").toString());
		txt_annualmileage.sendKeys(m.get("Vehicle_Annual Mileage").toString());
		 	}

		public void clickOnNextBtn() {
			btn_Next.click();
		}
	
		
	}
	
	

