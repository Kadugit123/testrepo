package StepDefinition;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*; 
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	ResponseSpecification respec;
	RequestSpecification res;
	Response response;
	TestDataBuild payload=new TestDataBuild();	
	
	@Given("Add Place Payload")
	public void add_place_payload() throws FileNotFoundException
	 {
		res=given().spec(requestSpecification()).body(payload.addPlacePayload());
	}
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		respec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=res.when().post("/maps/api/place/add/json").then().spec(respec).extract().response();
		String resString=response.asString(); 
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	   
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		String resString=response.asString();
		JsonPath js=new JsonPath(resString);
		assertEquals(js.get(key).toString(),value);
	}
}
