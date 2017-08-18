package com.vikash.sample;

public class Stringdemo {
	public static void main(String[] args)
	{
		String s= "vikash";
		String s1= "xyz";
		String s2=s+s1;
		String s3=s+s1;
		String s9="java string split method by javatpoint";  
		String[] words=s9.split("\\s");  
 
		for(String w:words){  
		System.out.println(w);  
		}
		
		System.out.println(s);
		StringBuffer s7= new StringBuffer("rama");
		StringBuffer s8=new StringBuffer("sita");
		s7.append(s8);

		System.out.println(s7.capacity());
		
		System.out.println(s7);
		
s.concat(s1);
System.out.println(s);
		if (s2.equals(s3))
		{
			System.out.println("strings are equal");
		}
		else
		{
			System.out.println("strings are not equal");
		}
	}
}
