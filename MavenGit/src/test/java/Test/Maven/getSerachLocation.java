package Test.Maven;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import File.ReusableMethod;
import File.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class getSerachLocation {
	
	
	Properties prop = new Properties();

@BeforeTest

public void getData() throws IOException{
	
	FileInputStream fis = new FileInputStream("E:\\Codes\\Maven\\src\\main\\java\\File\\env.properties");
	prop.load(fis);
	
}

@Test
public void getSearchLocation(){
	
	
	 RestAssured.baseURI=prop.getProperty("HOST");
		
		Response res=	given().log().all().
			
			param("location",prop.getProperty("LOCATION")).
			param("radius",prop.getProperty("RADIUS")).
			param("key",prop.getProperty("KEY")).

		when().
		get(resources.getPlaceData()).
		then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all().
		body("results[0].name",equalTo("Sydney")).and().
		extract().response();
		
		String respon= res.asString();
		System.out.println(respon);
		
		JsonPath js = ReusableMethod.rawToJson(res);
		String next_page_token = js.get("next_page_token");
		System.out.println(next_page_token);
		int count = js.get("results.size()");
		System.out.println("");
		for(int i=0;i<count;i++)
		{
			System.out.println(js.get("results["+i+"].name"));
		}
			

}

}
