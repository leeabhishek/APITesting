package File;

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

}
