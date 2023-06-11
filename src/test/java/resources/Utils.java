package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Utils {
	public static RequestSpecification req;
	    
	public RequestSpecification requestspecification() throws IOException {
		
		if(req==null) 
		{
		PrintStream log=new PrintStream(new FileOutputStream("Logging.txt"));
		
		 req=new RequestSpecBuilder().setBaseUri((getbaseuri("baseuri")))
				.addQueryParam("key","qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();	

		  return req; 
     	}
		return req;
	}

	public  String getbaseuri(String key) throws IOException {
		Properties prop=new Properties();
	   	FileInputStream fis =new FileInputStream("C:\\Users\\237529\\eclipse-workspace\\API_Framework\\src\\test\\java\\resources\\global.properties");
	    prop.load(fis);
	   return prop.getProperty(key);
	    
	}
	public String getJSonpath(Response response,String keyvalue) {
		String result=response.asString();
		JsonPath js= new JsonPath(result);
		//System.out.println(js.get(key));
	   return js.get(keyvalue).toString();
		
}
}
