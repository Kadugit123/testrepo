package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
			
		RequestSpecification req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).			
				setContentType(ContentType.JSON).build();
		
		return req;
	}
	public static String getGlobalValue(String url) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\chandu\\Desktop\\AUTOMATION_ENG\\CucumberApi\\src\\test\\java\\resources\\global.properties");
		p.load(fis);
		return p.getProperty("baseUrl");
		
	}

}
