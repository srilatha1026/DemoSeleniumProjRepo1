package com.ipivot.InsuranceCalculator.Utilities;

import java.io.IOException;
import java.util.Properties;

public class PropertyOperations {
	
	//we just have config.properties where we have stored configurable data like url,uname,pwd etc.,
	//how to read configurable props is we will be taking reference of properties
		//1.Load config.properties file into the properties instance.So create the instance of preoperties class
		//2.Read the data which we want from properties instance
	//creating constructor ofthe class to load the file
	
	//Properties is pre-defined class or inbuilt class in java.we are using it in-order to load the config.properties file and read data from it.
			// instance of properties class is created in order to do the above.
			Properties prop = new Properties(); 
	
	public PropertyOperations() {
		//Load config.properties file
		try {
			prop.load(PropertyOperations.class.getResourceAsStream("/propertiesFiles/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	//create a method that defines loading the prop file and reading data
	public String getPropertyValueByKey(String key) {
		
		//get the data required using getProperty(Key) method which will give the value of the specified key from the config.properties file in the method()
		//prop.getProperty("url");
		//the key can be anything that we want to read. we would be accessing it many time through getPropertyValueByKey() method. so do not hard core it as above:
		//instead do below: so we put getPropertyValueByKey(String key) while defining the method
		String str = prop.getProperty(key);
		if(str == null || str =="") {
			System.out.println("Value found null or blank in properties file for key:" + key);
		}
		return str;
			
	}
	
	
}
