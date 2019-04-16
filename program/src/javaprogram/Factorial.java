package javaprogram;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		int fact=1;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the number");
		
		int num = s.nextInt();
		
		for(int i=1;i<=num;i++){
			
			fact=fact*i;
			
			
		}
		
		
		System.out.println("Factorial of given no ="+fact);
		
		

	}

	
	
	
	
}
