package javaprogram;

public class ReverseInteger {

	public static void main(String[] args) {
		
		//By using algo
		
		int num = 12345;//54321
		
		int rev=0;
		
		while(num!=0){
			
			rev = rev*10 + num%10;
			num = num/10;
			
			
			
		}
		
		System.out.println(rev);
		
		
		//By using StringBuffer
		
		String str = String.valueOf(12345);//convert int value to string
		
		StringBuffer buffer = new StringBuffer(str).reverse();//then we can reverse
		
		System.out.println(Integer.parseInt(buffer.toString()));//now converting string to int then printing
		
		
		
		}

}
