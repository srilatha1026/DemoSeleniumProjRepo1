package Unused_com.CompName.SDET_Nov_2019;

public class ArrayDemo {

	public static void main(String[] args) {
		 
		int[] arrName = new int[3]; //declaring an array with capacity 3
		arrName[0]=1;
		arrName[1]=2;
		arrName[2]=3; 
		//arrName[3]=4; cannot add elements to an array or delete items. but create a new array or change the size while declaring the array
		
		String str1 = "Hello all how are you";
		String[] str2 = str1.split("all");//split always breaks the string and returns string array
		
		for(int i=0;i<str2.length;i++) {
			System.out.println(str2[i]);
			
		}
		System.out.println("Length of Str2:"+str2.length);
	}

}
