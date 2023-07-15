package github;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	
	@Test
	public void test1()
	{
		
		RestAssured.baseURI = "https://api.github.com/repos";
		RequestSpecification request = RestAssured.given();
		
		Response response = request
						.auth().oauth2("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")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
																									
									.delete("/Prathiba85/RestAssuredDemo");
		
		
		String body = response.getBody().asString();
		System.out.println("Response body is " + body);
		
		System.out.println("Response code is " + response.statusCode());
		Assert.assertEquals(response.statusCode(),204);
		
		
		
	}

				
	}


