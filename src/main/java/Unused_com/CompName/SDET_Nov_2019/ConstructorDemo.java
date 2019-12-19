package Unused_com.CompName.SDET_Nov_2019;

import com.ipivot.InsuranceCalculator.PageObject.FillVehicleDataPage;

public class ConstructorDemo {
int a ;
int b ;
	public ConstructorDemo(int x,int y) {
		//this is the constructor
		//initialize the variables
		a=x;
		b=y;
	}
	
	public void add() {
		System.out.println("Sum is:"+(a+b));
	}
	
	public static void main(String[] args) {
		ConstructorDemo c = new ConstructorDemo(10,20);
		ConstructorDemo c1 = new ConstructorDemo(100,300);
	
		c.add();
		c1.add();
		
	}
	
}
