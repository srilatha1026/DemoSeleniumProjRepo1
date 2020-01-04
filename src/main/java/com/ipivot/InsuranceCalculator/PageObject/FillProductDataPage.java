package com.ipivot.InsuranceCalculator.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ipivot.InsuranceCalculator.Utilities.CommonMethods;

public class FillProductDataPage {
	
	CommonMethods cm = new CommonMethods();
	
	@FindBy(name="Start Date")
	WebElement txt_StartDate;

	@FindBy(name="Insurance Sum")
	WebElement dd_InsuranceSum;
	
	@FindBy(id="meritrating")
	WebElement dd_meritrating;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List<WebElement> ChckBox_OptionalProducts;
	
	@FindBy(id="courtesycar")
	WebElement dd_courtesycar;
	
	@FindBy(name="Next (Select Price Option)")
	WebElement btn_Next;


//Iniatialise the web elements
	
	public FillProductDataPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

	public void fillActualProductData(Map m) {
		txt_StartDate.sendKeys(m.get("Product_startdate").toString());
		cm.selectValueFromDropDown(dd_InsuranceSum, m.get("Product_insurancesum").toString());
		cm.selectValueFromDropDown(dd_meritrating,  m.get("Product_meritrating").toString());
		cm.selectValueFromDropDown(dd_damageinsurance,  m.get("Product_damageinsurance").toString());
		
		List<String> OptionalProduct = new ArrayList<String>();
		OptionalProduct.add("Euro Protection");
		cm.selectCheckBox(ChckBox_OptionalProducts, OptionalProduct);
//		cm.selectCheckBox1(ChckBox_OptionalProducts, m.get("Product_OptionalProducts").toString());
		cm.selectValueFromDropDown(dd_courtesycar, m.get("Product_courtesycar").toString());
	
	}
	
	public void clickOnNext() {
		btn_Next.click();
	}


}
