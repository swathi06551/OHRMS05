package com.inheritanceExample;

public class InheritanceExample {
	
	public void addition()
	{
		int var1=89;
		int var2=69;
		int var3;
		
		var3=var1+var2;
		System.out.println("addition of var1 and var2 is "+var3);
	}
	public static void main(String[] args)
	{
		InheritanceExample ie1 = new InheritanceExample();
		ie1.addition();
	}

}
