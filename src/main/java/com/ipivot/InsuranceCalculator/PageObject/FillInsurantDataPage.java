package com.ipivot.InsuranceCalculator.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillInsurantDataPage {

	//Page Factory
		@FindBy(id="firstname")
		WebElement txt_FirstName;
		
		@FindBy(id="lastname")
		WebElement txt_lastName;
		
		@FindBy(id="birthdate")
		WebElement txt_DOB;
		
		@FindBy(xpath="//input[@name='Gender']")
		List<WebElement> RadBtn_Gender;
		
		@FindBy(id="country")
		WebElement select_country;
		
		@FindBy(id="zipcode")
		WebElement txt_zipcode;
		
		@FindBy(id="occupation")
		WebElement txt_occupation;
		
		@FindBy(xpath="//input[@name='Hobbies']")
		List<WebElement> ChckBox_Hobbies;
	
		@FindBy(name="Next (Enter Product Data)")
		WebElement btn_Next;
	
		//We need to initaialise the webelementsby creating constructor of this page
		
	public FillInsurantDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
}
