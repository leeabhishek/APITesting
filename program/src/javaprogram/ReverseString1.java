package javaprogram;

public class ReverseString1 {

	public static void main(String[] args) {
	
	
		String str="hi i am abhishek";
		
		int len=str.length();
		
		for(int i=len-1;i>=0;i--){
			
			System.out.print(str.charAt(i));
		}
		

	}

}
