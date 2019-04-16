package javaprogram;

public class RemoveJunk {

	
	public static void main(String args[]){
	
	String str = "$$$$ Hi %%%&##@ This is *&^%$# Abhishek $#@!%^&";
	
	//By using Regular Expression.[^a-zA-Z0-9]
	
	
	 str = str.replaceAll("[^a-zA-Z0-9]", "");
	
	
	System.out.println(str);
	
	
	}

}

