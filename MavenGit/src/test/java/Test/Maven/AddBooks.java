package Test.Maven;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import File.ReusableMethod;
import File.dataDriven;

public class AddBooks {
	
	
	@Test
	public void addBook() throws IOException
	{
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("RestAddbook", "RestAssured");
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		
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
		
		
		Assert.assertEquals(js.get("Msg"), "successfully added");
		Assert.assertEquals(js.get("ID"), "123456ab8465");
		
	}

	
	@Test
	public void deleteBook()
	{
		
		
		
	}
	

}
