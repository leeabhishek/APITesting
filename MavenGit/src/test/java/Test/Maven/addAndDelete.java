package Test.Maven;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import File.ReusableMethod;
import File.resources;

public class addAndDelete {
	
	
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
	
		FileInputStream fis = new  FileInputStream("E:\\Codes\\Maven\\src\\main\\java\\File\\env.properties");
		prop.load(fis);
	}
	
	
	@Test
	public void addBook() throws IOException
	{
		RestAssured.baseURI=prop.getProperty("BOOKHOST");
		Response res=given().log().all().
				body(ReusableMethod.GenerateStringFromResources("E:\\Codes\\Maven\\addBook.json")).
				when().post(resources.getAddBookData()).then().
				log().all().assertThat().statusCode(200).extract().response();
		//System.out.println(res.asString());
		JsonPath js=ReusableMethod.rawToJson(res);
		String bookID=js.get("ID");
		System.out.println(bookID);
		System.out.println("-----------------------------------------------------------------------");
		
		given().log().all().
		body("{"+
			 
			"   \"ID\" : \""+bookID+"\""+
			 
			"} ").
			when().post(resources.geteDeleteResource()).then().log().all().
			assertThat().statusCode(200).contentType(ContentType.JSON).and().
			body("msg", equalTo("book is successfully deleted"));
	
	
	}

}
