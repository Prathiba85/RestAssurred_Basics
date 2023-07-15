package springBooot;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployee {
	@Test
	public void get()
	{
	RestAssured.baseURI = "http://localhost:8088/employees";
	//The given method will assign the request
	RequestSpecification request = RestAssured.given();
	Response response = request.get();
			
			
	//asString is the method created by rest assured to fetch body data as String.
	String body = response.getBody().asString();
	System.out.println("Response body " + body);
	System.out.println("Status Code  is :"+response.statusCode());
	JsonPath json = response.jsonPath();
	List <String> names = json.get("firstName");
	int size = names.size();
	List <Integer> Ids = json.get("id");
	
	for (int i = 0;i<size;i++)
	{
		System.out.println( " Id is "+Ids.get(i)+" name is : "+names.get(i));
	}
	
	}

}
