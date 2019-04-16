package javaprogram;

import java.util.Scanner;

public class GetInputFromUser {

	public static void main(String[] args) {
		
		
		
		int a;
		float b;
		String c;
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the integer number");
		
		a= in.nextInt();
		
		System.out.println("You Entered Integer"+a);
		
		System.out.println("Enter the Float number");
		
		b=in.nextFloat();
		
		System.out.println("You Entered Float"+b);
		
		System.out.println("Enter the String");
		
		c=in.nextLine();
		
		System.out.println("You Entered the String"+c);

	}

}
