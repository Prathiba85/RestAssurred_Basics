package springBooot;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GetAccessToken {
	public static String token;
	public static void main (String[] args)
	{
	//public static String getToken()
	//{

	Response response = RestAssured.given()
						.baseUri("http://localhost:8088")
						.auth().basic("rest-assured", "password")
						.contentType ("application/x-www-form-urlencoded")
						.formParams("grant_type","password")
						.formParams("username","onlyfullstack")
						.formParams("password","secret")
						.when()
						.post("/oauth/token");
	
	JsonPath jpath = response.jsonPath();
	 token = jpath.getString("access_token");
	System.out.println("Response is "+response.getBody().asString());
	
	System.out.println("Access Token: "+token);
	
	get_Employee();
	
	//return token;
	}
	
	public static void get_Employee()
	{
		Response response_get = RestAssured.given()
				.baseUri("http://localhost:8088")
				.headers("Authorization","Bearer "+token)
				.when()
				.get("/students");
			
		
		System.out.println(response_get.asString());
		
		/* Get Students using OAuth
		 
		 Response response_get = RestAssured.given()
				.baseUri("http://localhost:8088")
				.auth().oauths(token)
				.when()
				.get("/students");*/
	}
		
}
//}
