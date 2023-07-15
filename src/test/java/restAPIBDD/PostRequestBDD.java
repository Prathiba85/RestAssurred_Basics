package restAPIBDD;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {
	@Test
	public void test1()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "VimalPrabhutest");
		jobj.put("salary", "3000");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.baseUri("http://localhost:3000/employees")
		.body(jobj.toString())
		.when()
		.post("/create")
		.then()
		.log().body()
		.statusCode(201);
		
		
	}
}
