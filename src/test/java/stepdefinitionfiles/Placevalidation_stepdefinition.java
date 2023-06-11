package stepdefinitionfiles;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import pojo.Add_Place;
import pojo.Location;
import resources.Apiresources;
import resources.Testdatabuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Placevalidation_stepdefinition extends Utils {
	 RequestSpecification res;
	 ResponseSpecification resspec;
	 Response response;
	 Testdatabuild data=new Testdatabuild();
	static String placeid;
	
	 @Given("Add place payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
	    
		   res=given().spec(requestspecification()).body(data.addplacepayload(name, language, address));	   
	}
	 

	 @When("user calls {string} using http {string} request")
	 public void user_calls_using_http_request(String resource, String httpmethod) {
	    
		 //constructor will called with value of resource which we pass
		Apiresources ar= Apiresources.valueOf(resource);
		System.out.println(ar.getResource());
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		  if(httpmethod.equalsIgnoreCase("POST"))	  
		  response= res.when().post(ar.getResource());
		  else if(httpmethod.equalsIgnoreCase("GET"))
			response= res.when().get(ar.getResource());			  
	}
		    
	@Then("Api call is success with statuscode {int}")
	public void api_call_is_success_with_statuscode(Integer int1) {
		  int statuscode= response.getStatusCode();
		  Assert.assertEquals(statuscode,int1);		
	}
	   
	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String value) {
		
	   Assert.assertEquals( getJSonpath(response,key),value);   
	}
	
	@Then("verify palce_Id created which maps to {string} using {string}")
	public void verify_palce_id_created_which_maps_to_using(String expectedname, String resource) throws IOException {
		
		 placeid= getJSonpath(response,"place_id");
		 res=given().spec(requestspecification()).queryParams("place_id", placeid);
		 user_calls_using_http_request(resource,"GET");
		 String actualname = getJSonpath(response,"name");
		 System.out.println(actualname);
		 Assert.assertEquals(actualname, expectedname);	    
	}

  @Given("Delete payload")
    public void delete_payload() throws IOException {
	res=given().spec(requestspecification()).body(data.deleteplacepayload(placeid));
}
}
