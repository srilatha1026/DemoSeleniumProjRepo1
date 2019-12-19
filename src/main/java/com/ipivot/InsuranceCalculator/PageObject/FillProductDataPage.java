package com.ipivot.InsuranceCalculator.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillProductDataPage {

	@FindBy(name="Start Date")
	WebElement txt_StartDate;

	@FindBy(name="Insurance Sum")
	WebElement txt_InsuranceSum;
	
	@FindBy(id="meritrating")
	WebElement txt_meritrating;
	
	@FindBy(id="damageinsurance")
	WebElement select_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']")
	List<WebElement> ChckBox_OptionalProducts;
	
	@FindBy(id="courtesycar")
	WebElement select_courtesycar;
	
	@FindBy(name="Next (Select Price Option)")
	WebElement btn_Next;


//Iniatialise the web elements
	
	public FillProductDataPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}





}
