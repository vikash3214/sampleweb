package com.vikash.sample;

public  class Animal {

 void eat(){
		System.out.println("animal eat");
	}
	 void run(){
		 System.out.println("anmal run");
	 }
	 void cry()
	 {
	
		 System.out.println("animal is crying");
	 }
	
	
	void permit(Animal ref)
	{
		ref.eat();
		ref.cry();
		ref.run();
		
	}
}