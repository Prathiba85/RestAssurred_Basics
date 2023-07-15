package restAPIBDD;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestBDD {
	@Test
	public void test1()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "VimalPrabhuupdated");
		jobj.put("salary", "5000");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.baseUri("http://localhost:3000/employees")
		.body(jobj.toString())
		.when()
		.put("/19")
		.then()
		.log().body()
		.statusCode(200);
		
		
	}
}
