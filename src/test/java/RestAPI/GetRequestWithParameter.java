package RestAPI;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameter {
	@Test
	public void test1()
	{
		// Get single employee
		
		//Base URI is a static variable in Rest assured class 
		RestAssured.baseURI = "http://localhost:3000/employees";
		//The given method will assign the request
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/1");
				
		
		String body = response.getBody().asString();
		System.out.println("Response body " + body);
		System.out.println("Status Code  is :"+response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		
		Assert.assertTrue(body.contains("Pankaj"));
		// We have only one name so no need for list.
		JsonPath json = response.jsonPath();
		
		String name=json.get("name");
		Assert.assertEquals(name,"Pankaj");
		
		
	}


}
