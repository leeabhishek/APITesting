package javaprogram;

public class PalindromeString {

	public static void main(String[] args) {
		

		StringBuffer str = new StringBuffer("BOB");
		StringBuffer st1= str.reverse();
		
		if(str.equals(st1))
		{
			System.out.println("String is Palindrome");
		}
		
		else
		{
			System.out.println("String is not Palindrome");
		}
		
	}

}
