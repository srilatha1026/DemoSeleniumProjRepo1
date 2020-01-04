package com.ipivot.InsuranceCalculator.Utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public void selectValueFromDropDown(WebElement ele, String valueToBeSelected) {
		Select DDSelect= new Select(ele);
		DDSelect.selectByVisibleText(valueToBeSelected);
	}
	
	public void selectRadioButtonValue(List<WebElement> Listele,String valueToBeSelected) {
		for(int i =0;i<Listele.size();i++) {
			if(Listele.get(i).getText().equalsIgnoreCase(valueToBeSelected)) {
				Listele.get(i).click();
		}
		
	}

	}
	
	public void selectCheckBox(List<WebElement> Listele, List<String> str) {
		for(String chckbox : str) {
			
		
		for(int i=0;i<Listele.size();i++) {
			if(Listele.get(i).getText().equalsIgnoreCase(chckbox)) {
				Listele.get(i).click();
				break;
			}
		}
	}
	}
	
//	public void selectCheckBox1(List<WebElement> Listele,String valueToBeChecked) {
//		for(int i=0;i<Listele.size();i++) 
//			{
//			if(Listele.get(i).getText().equalsIgnoreCase(valueToBeChecked)) 
//				{
//				Listele.get(i).click();
//				break;
//				}
//			}
//	}
	
}
