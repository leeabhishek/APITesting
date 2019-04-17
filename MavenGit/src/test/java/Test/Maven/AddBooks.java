package Test.Maven;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import File.ReusableMethod;
import File.dataDriven;
import File.resources;

public class AddBooks {
	
	
	@Test
	public void addBook() throws IOException
	{
//		dataDriven d = new dataDriven();
//		ArrayList data = d.getData("RestAddbook", "RestAssured");
//		
//		
//	
//		
//		List<Object> masterAList = new ArrayList<Object>(); 
//		
//		Map<String,Object> a1 = new LinkedHashMap<>(); 
//		a1.put("name", data.get(1));
//		a1.put("isbn", data.get(2));
//		a1.put("aisle", data.get(3));
//		a1.put("author", data.get(4));
//        masterAList.add(a1);
//	        
//	   
//	        
//	        Map<String,Object> a2 = new LinkedHashMap<>(); 
//	        a2.put("name", data.get(6));
//			a2.put("isbn", data.get(7));
//			a2.put("aisle", data.get(8));
//			a2.put("author", data.get(9));
//			masterAList.add(a2);
//	       
//	
//	    	
//	        Map<String,Object> a3 = new LinkedHashMap<>(); 
//	        a3.put("name", data.get(11));
//			a3.put("isbn", data.get(12));
//			a3.put("aisle", data.get(13));
//			a3.put("author", data.get(14));
//            masterAList.add(a3);
//	        
//	    
//	    	
//	        Map<String,Object> a4 = new LinkedHashMap<>(); 
//
//	        a4.put("name", data.get(16));
//			a4.put("isbn", data.get(17));
//			a4.put("aisle", data.get(18));
//			a4.put("author", data.get(19));
//	        masterAList.add(a4);
//	        
//	    
//	    	System.out.print("");
//	    	
		
		
		List<Object> masterAList = ReusableMethod.getExcelData();

	        
	        
	for(int i=0;i<masterAList.size();i++)
	{
		Map<String,Object> map = new LinkedHashMap<>();
		Map<String,Object> oo = (Map<String, Object>) masterAList.get(i);
		
		for (Map.Entry<String,Object> entry : oo.entrySet()) { 
        System.out.println("Key = " + entry.getKey() + 
                ", Value = " + entry.getValue()); 
		
		
	
	
		map.put(entry.getKey(), entry.getValue());
		
		
		 
		
	
	}
	    	RestAssured.baseURI = "http://216.10.245.166";
			Response res =given().
					header("Content-Type","application/json").
					body(map).
					when().
					post("/Library/Addbook.php").
					then().assertThat().statusCode(200).
					extract().response();
			System.out.println(res.asString());
			JsonPath js = ReusableMethod.rawToJson(res);
			
			String bookID = js.get("ID");
			System.out.println(bookID);
			
			Assert.assertEquals(js.get("Msg"), "successfully added");	
			
			
			given().log().all().
			body("{"+
				 
				"   \"ID\" : \""+bookID+"\""+
				 
				"} ").
				when().post(resources.geteDeleteResource()).then().log().all().
				assertThat().statusCode(200).contentType(ContentType.JSON).and().
				body("msg", equalTo("book is successfully deleted"));

	}
	
	}
}


