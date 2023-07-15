package restAPIBDD;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	@Test
	public void test1()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log().body()
		.statusCode(200)
		.body("[3].name",Matchers.equalTo("Rohan"));
		
	}
	
	//@Test
	public void test2()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("/14")
		.then()
		.log().all()
		.statusCode(200)
		.body("name",Matchers.equalTo ("Dhivya"));
		
		
	}
	@Test
	public void test3()
	{
		Response response = RestAssured.given()
				.baseUri("http://localhost:3000/employees")
				.when()
				.get();
		JsonPath js = response.jsonPath();
		
		Assert.assertEquals(response.statusCode(),200);		
		//Assert name
		List <String> names = js.get("name");
		List <Integer> ids = js.get("id");
		boolean flag = false;
		for (String name:names)
		{
			if (name.equalsIgnoreCase("Rohan"))
			{
				flag =true;
				break;
					}
			
		}
		
		Assert.assertEquals(flag, true);
		
		//Check if a particular name is available in particular employee id
		
		int empid =3;
		
		for(int i =0;i<ids.size();i++)
		{
			if ((ids.get(i)== empid))
			{
				Assert.assertEquals(names.get(i), "Vidhya");
			}
		}
		
		
	}

}
