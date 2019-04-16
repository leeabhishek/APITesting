package javaprogram;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		
		
		int i,j,flag=0;
		
		System.out.println("Enter any no which you want to verify");
		
		
		Scanner s = new Scanner(System.in);
		j=s.nextInt();
		
		s.close();
		for(i=2;i<j;i++)
		{
			if(j%i==0)
			{
				flag=0;
				break;
			}
			
			else
			{
				
				flag=1;
			}
			
			
		}
		
		if(flag==1)
		{
			System.out.println(j+"  is a prime no");
		}
		else{
			
			System.out.println(j+" is not prime no");
		}

	}

}
