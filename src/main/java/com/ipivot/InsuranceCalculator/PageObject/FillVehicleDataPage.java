package com.ipivot.InsuranceCalculator.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillVehicleDataPage {

	//Page Factory
	@FindBy(id="make")
	WebElement dd_make;
	
	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_CylinderCapacity;
	
	@FindBy(xpath="//input[@id='engineperformance']")
	WebElement txt_engineperformance;
	
	@FindBy(xpath="//select[@id='numberofseats']")
	WebElement sel_noOfSeats;
		
	@FindBy(xpath="//input[@name='Right Hand Drive']")
	List<WebElement> rdbtn_isRightHandDrive;
	
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
	//constructor of current class,use PageFactory class
	
	public FillVehicleDataPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	
	public void FillActualVehicleData() {
		
	}


	
		
	}
	
	

