package File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethod {
	
	
	public static JsonPath rawToJson(Response r)
	{
		
		String response = r.asString();
		JsonPath j = new JsonPath(response);
		return j;
		
	}
	
	
	public static XmlPath rawToXML(Response r)
	{
		
		String response = r.asString();
		XmlPath x = new XmlPath(response);
		return x;
	}
	
	

	public static String GenerateStringFromResources(String Path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(Path)));
	}
	
	
	public static List<Object> getExcelData() throws IOException{
		
		
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("RestAddbook", "RestAssured");
		
		
	
		
		List<Object> masterAList = new ArrayList<Object>(); 
		
		Map<String,Object> a1 = new LinkedHashMap<>(); 
		a1.put("name", data.get(1));
		a1.put("isbn", data.get(2));
		a1.put("aisle", data.get(3));
		a1.put("author", data.get(4));
        masterAList.add(a1);
	        
	   
	        
	        Map<String,Object> a2 = new LinkedHashMap<>(); 
	        a2.put("name", data.get(6));
			a2.put("isbn", data.get(7));
			a2.put("aisle", data.get(8));
			a2.put("author", data.get(9));
			masterAList.add(a2);
	       
	
	    	
	        Map<String,Object> a3 = new LinkedHashMap<>(); 
	        a3.put("name", data.get(11));
			a3.put("isbn", data.get(12));
			a3.put("aisle", data.get(13));
			a3.put("author", data.get(14));
            masterAList.add(a3);
	        
	    
	    	
	        Map<String,Object> a4 = new LinkedHashMap<>(); 

	        a4.put("name", data.get(16));
			a4.put("isbn", data.get(17));
			a4.put("aisle", data.get(18));
			a4.put("author", data.get(19));
	        masterAList.add(a4);
	        
	        return masterAList;
		
	}

}
