package RESTAPIxml;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	@Test
	public void test1()
	{
		Response response = RestAssured.given()
								.baseUri("http://chercher.tech/sample/api/books.xml")
								.when()
								.get();
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.author");
	//	System.out.println("All the books are "+books.toString());
	//	System.out.println("All the books are "+books.get(0).toString());
	//	System.out.println("All the books are "+books.get(1).toString());
		
		// Below code will get Attribute of the main tag.
		
		NodeChildrenImpl booksTag = response.then().extract().path("bookstore.book");
		
		for( int i=0;i<booksTag.size();i++)
		{
			System.out.println(booksTag.get(i).getAttribute("category"));
		}
	}

}
