package com.vikash.sample;

public class Launch {

	public static void main(String[] args) {
		/*Animal aa;
		 aa=new Dog();
		
		
		aa.cry();
		aa.eat();
		aa.run();
		
		aa=new Cat();
		aa.eat();
		aa.run();
		aa.cry();	
		((Cat) aa).scratch();
	*/
	
	Cat c= new Cat();
	Dog d= new Dog();
	Animal a= new Animal();
	  a.permit(c);
      a.permit(d);	
	
	
	}

}
