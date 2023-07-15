package RestAPI;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test1()
	{
		// Get all employee
		
		//Base URI is a static variable in Restassured class 
		RestAssured.baseURI = "http://localhost:3000/employees";
		//The given method will assign the request
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
				
				
		//asString is the method created by rest assured to fetch body data as String.
		String body = response.getBody().asString();
		System.out.println("Response body " + body);
		System.out.println("Status Code  is :"+response.statusCode());
		System.out.println("Response Header is :"+response.getHeader("Content-Type"));
		System.out.println(response.getHeaders().asList());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.jsonPath();
		
		HashMap <Integer,String> employees = new HashMap ();
				
			List <String> names = json.get("name");
			int size = names.size();
			List <Integer> Ids = json.get("id");
			for (String name : names)
			{
				System.out.println(name );
			
		}
			
			for (int i = 0;i<size;i++)
			{
				System.out.println( " Id is "+Ids.get(i)+" name is : "+names.get(i));
			}
	
	 
		
	}

}
