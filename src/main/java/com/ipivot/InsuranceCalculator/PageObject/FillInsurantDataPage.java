package com.ipivot.InsuranceCalculator.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ipivot.InsuranceCalculator.Utilities.CommonMethods;

public class FillInsurantDataPage {
	CommonMethods cm = new CommonMethods();
	//Page Factory
		@FindBy(id="firstname")
		WebElement txt_FirstName;
		
		@FindBy(id="lastname")
		WebElement txt_lastName;
		
		@FindBy(id="birthdate")
		WebElement txt_DOB;
		
		@FindBy(xpath="//input[@name='Gender']/parent::label")
		List<WebElement> RadBtn_Gender;
		
		@FindBy(id="country")
		WebElement select_country;
		
		@FindBy(id="zipcode")
		WebElement txt_zipcode;
		
		@FindBy(id="city")
		WebElement txt_city;
		
		@FindBy(id="occupation")
		WebElement DD_occupation;
		
		@FindBy(xpath="//input[@name='Hobbies']/parent::label")
		List<WebElement> ChckBox_Hobbies;
	
		@FindBy(name="Next (Enter Product Data)")
		WebElement btn_Next;
	
		//We need to initaialise the webelementsby creating constructor of this page
		
	public FillInsurantDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillActualInsurantData(Map m) {
		txt_FirstName.sendKeys(m.get("Insurant_FirstName").toString());
		txt_lastName.sendKeys(m.get("Insurant_LastName").toString());
		txt_DOB.sendKeys(m.get("Insurant_birthdate").toString());
		cm.selectRadioButtonValue(RadBtn_Gender, m.get("Insurant_gender").toString());
		cm.selectValueFromDropDown(select_country,  m.get("Insurant_country").toString());
		txt_zipcode.sendKeys( m.get("Insurant_zipcode").toString());
		txt_city.sendKeys("Cranbury");
		cm.selectValueFromDropDown(DD_occupation, m.get("Insurant_occupation").toString());
		
		//create a common method for checkboxes in commonmethods class
		//creating array list temporarily
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Speeding");
		hobbies.add("Other");
		cm.selectCheckBox(ChckBox_Hobbies,hobbies);
//				cm.selectCheckBox1(ChckBox_Hobbies, m.get("Insurant_Hobby").toString());
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}
	
	
	
	
	
	
}
