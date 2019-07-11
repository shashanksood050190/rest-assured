package authenticationRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class afterAuthenticationGetData extends BaseClass{

	@Test
	public void testAuthentication() {
		int code=RestAssured.given().when().get().getStatusCode();
		Assert.assertEquals(code, 200);
	}

}
