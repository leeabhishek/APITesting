package javaprogram;

public class SwapString {

	public static void main(String[] args) {
	
		
		String a = "Hello";
		String b = "World";
		
		System.out.println("Before Swapping:  ");
		System.out.println("The value of a is:"+ a);
		System.out.println("The value of b is:"+ b);
		
		
		//append a and b first by using + operator

		
		a=a+b;//HelloWorld
		
		b=a.substring(0,a.length()-b.length());
		
		a=a.substring(b.length());
		
		System.out.println("");
		System.out.println("After Swapping:  ");
		
		System.out.println("The value of a is:"+ a);
		System.out.println("The value of b is:"+ b);
		
		
	}

}
