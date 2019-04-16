package javaprogram;

public class DuplicatesElementsArray {

	public static void main(String[] args) {
		
		
		String names[] = {"Java","JavaScript","Ruby","C","Python","Java"};
		
		for(int i=0; i<names.length; i++){
			
			for(int j=i+1; j<names.length; j++){
				
				
				
				if(names[i].equals(names[j])){
					
					
					System.out.println("Duplicate No is :::"+names[i]);
				}
				
			}
			
			
			
		}
		

	}

}
