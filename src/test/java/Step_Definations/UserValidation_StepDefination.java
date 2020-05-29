package Step_Definations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import POJO.UserLogin;
import Resources.API_Resources;
import Resources.Test_Data;
import Resources.Utils;
import groovyjarjarpicocli.CommandLine.Spec;

public class UserValidation_StepDefination extends Utils {

	RequestSpecification rqsp;
	ResponseSpecification resp;
	public static Response response;
	public static String Token = "";
	Test_Data data = new Test_Data();

	@Given("user login payload with {string} and {string}")
	public void user_login_payload_with_and(String Email, String Password) throws IOException {

		rqsp = given().spec(requestSpecifications()).body(data.UserValidationPayLoad(Email, Password));

	}

	@When("user call {string} API with {string} http request")
	public void user_call_API_with_http_request(String resource, String method) {

		API_Resources apiresource = API_Resources.valueOf(resource);

		System.out.println(apiresource.getResource());

		apiresource.getResource();

		resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))

			response = rqsp.when().post(apiresource.getResource());

		else if (method.equalsIgnoreCase("GET"))

			response = rqsp.when().get(apiresource.getResource());


	}

	@Then("API call got sucess with Status {int}")
	public void api_call_got_sucess_with_Status(Integer int1) {
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Key_Value, String Expected_Value) {
		Token = getJsonPath(response, "data.auth_token");
		assertEquals(getJsonPath(response, Key_Value), Expected_Value);

	}
	
/*	@Given("country_List payload")
	public void country_list_payload() throws IOException {
	rqsp = given().spec(requestSpecifications());
	rqsp.header("x-service-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.e30.aIHewsQGwbYfjqBFNR-u4iqdnXOy6_baPUBisDWgc48");
	    
	}*/
	

	
	@Then("{string} in response {string}")
	public void in_response(String Key_Value, String Expected_Value) {
		assertEquals(getJsonPath(response, Key_Value), Expected_Value);
	}


	@Given("users payload")
	public void users_payload() throws IOException {
	rqsp = given().spec(requestSpecifications());
	rqsp.header("x-api-token",UserValidation_StepDefination.Token);

	}

	@Given("logout payload")
	public void logout_payload() throws IOException {
	rqsp = given().spec(requestSpecifications());
	rqsp.header("x-api-token",UserValidation_StepDefination.Token);
	Token = "";
	}

}
