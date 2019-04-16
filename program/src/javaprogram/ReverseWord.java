package javaprogram;

public class ReverseWord {
	
	
	
	/*
	We can reverse each word of a string by the help of reverse(), split() and substring() methods. By using reverse() method of StringBuilder class, 
	we can reverse given string. By the help of split("\\s") method, we can get all words in an array. 
	To get the first character, we can use substring() or charAt() method.
	*/
	
	public static void main(String[] args) {
	
	String str="my name is khan";
	
	String words[]=str.split("\\s");  
    String reverseWord="";  
  
    	
  	for (int i = 0; i < words.length; i++)
    
    {  
    		
    	String word = words[i]; 
        StringBuilder sb=new StringBuilder(word);  
        sb.reverse();  
        reverseWord+=sb.toString()+" ";  
    }  
	
    	System.out.println(reverseWord);

	}
}