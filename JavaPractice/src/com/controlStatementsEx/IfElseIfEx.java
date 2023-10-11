package com.controlStatementsEx;

public class IfElseIfEx {
	
	public static void main(String[] args) {
		
		double var1 = 40.5;
		double var2 = 38.5;
		double var3 = 35.5;
		
		if(var1 > var2)
		{
			System.out.println("var1 value is greater than var2 value");
		}
	     else if(var2 > var3)
	     {
		 System.out.println("var2 value is greater than var1 value and var3 value");
	     }
	    else
		System.out.println("var3 value is greater than var1 value and var2 value");
	
}
}