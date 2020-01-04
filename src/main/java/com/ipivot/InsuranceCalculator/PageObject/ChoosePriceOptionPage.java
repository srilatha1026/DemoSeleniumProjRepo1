package com.ipivot.InsuranceCalculator.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChoosePriceOptionPage {

	//PageFactory
	
	@FindBy(xpath="//table[@id='priceTable']/tbody/tr[1]/td[2]")
	WebElement fld_SilverPlanPrice;
	
	@FindBy(xpath="//table[@id='priceTable']/tbody/tr[1]/td[3]")
	WebElement fld_GoldPlanPrice;
	
	@FindBy(xpath="//table[@id='priceTable']/tbody/tr[1]/td[4]")
	WebElement fld_PlatinumPlanPrice;
	
	@FindBy(xpath="//table[@id='priceTable']/tbody/tr[1]/td[5]")
	WebElement fld_UltimatePlanPrice;
	
	@FindBy(xpath="//input[@id='selectsilver']/following-sibling::span")
	WebElement btn_selectSilver;
	
	@FindBy(xpath="//input[@id='selectgold']/following-sibling::span")
	WebElement btn_selectGold;
	
	@FindBy(xpath="//input[@id='selectplatinum']/following-sibling::span")
	WebElement btn_selectPlatinum;
	
	@FindBy(xpath="//input[@id='selectultimate']/following-sibling::span")
	WebElement btn_selectUltimate;
	
	@FindBy(id="nextsendquote")
	WebElement btn_next;

//verify the price for each plan individually
public ChoosePriceOptionPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

public void verifySilverPriceOption(String value){
	String actualsilverprice = fld_SilverPlanPrice.getText();
	Assert.assertEquals(actualsilverprice,"102.00", "The price is not same");
	}
public void verifyGoldPriceOption(String value){
	String actualgoldprice = fld_GoldPlanPrice.getText();
	Assert.assertEquals(actualgoldprice,"301.00", "The price is not same");
	}
public void verifyPlatinumPriceOption(String value){
	String actualplatinumprice = fld_PlatinumPlanPrice.getText();
	Assert.assertEquals(actualplatinumprice,"591.00", "The price is not same");
	}
public void verifyUltimatePriceOption(String value){
	String actualultimateprice = fld_UltimatePlanPrice.getText();
	Assert.assertEquals(actualultimateprice,"1,126.00", "The price is not same");
	}
	
//select the required option
public void selectSilverPlan()
	{
		btn_selectSilver.click();
	}

public void selectGoldPlan()
	{
		btn_selectGold.click();
	}

public void selectPLatinumPlan()
	{
		btn_selectPlatinum.click();
	}

public void selectUtimatePlan()
	{
		btn_selectUltimate.click();
	}

public void clickOnNextButton() 
	{
		btn_next.click();
	}



}