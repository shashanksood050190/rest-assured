package postPutDeleteRequest;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostPutDeleteData {

	@Test(priority = 1)
	public void testPost() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "seleniumWebdriver");
		json.put("author", "learnAutomation");

		request.body(json.toJSONString());

		Response response = request.post("http://localhost:3000/posts/");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 201);
	}

	@Test(priority = 2)
	public void testPut() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "jmeter");
		json.put("author", "learnPerformance");

		request.body(json.toJSONString());

		Response response = request.put("http://localhost:3000/posts/25");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);

	}

	@Test(priority = 3)
	public void testDelete() {
		RequestSpecification request = RestAssured.given();

		Response response = request.delete("http://localhost:3000/posts/25");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);

	}

}
