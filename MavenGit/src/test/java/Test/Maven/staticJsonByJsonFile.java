package Test.Maven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import File.ReusableMethod;

public class staticJsonByJsonFile {
	
	@Test(priority=1)
	public String addBook() throws IOException
	{
		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given().log().all().
				       
				       body(GenerateStringFromResources("E:\\Codes\\Maven\\addBook.json")).
				       when().
				       post("/Library/Addbook.php").
				       then().log().all().assertThat().statusCode(200).extract().response();
		System.out.println(res.asString());
		JsonPath js = ReusableMethod.rawToJson(res);
		String bookid = js.get("ID");
		System.out.println(bookid);
		return bookid;
		
		
		/*given().log().all().
		body("{"+
				 "\"ID\" : \""+bookid+"\""+
			"}").
		when().post("/Library/DeleteBook.php").then().
		log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("msg", equalTo("book is successfully deleted"));*/
				
	}
	
	
	@Test(priority=2)
	public void deleteBook() throws IOException
	{
		
		String Bookid=addBook();
		RestAssured.baseURI = "http://216.10.245.166";
		
		given().log().all().
		body("{"+
				 "\"ID\" : \""+Bookid+"\""+
			"}").
		when().post("/Library/DeleteBook.php").then().
		log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("msg", equalTo("book is successfully deleted"));
	}
	
	
	
	public static String GenerateStringFromResources(String Path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(Path)));
	}

}
