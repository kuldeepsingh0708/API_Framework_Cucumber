	package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import org.apache.http.util.TextUtils;
import Step_Definations.UserValidation_StepDefination;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils

{

	public static RequestSpecification req;

	public RequestSpecification requestSpecifications() throws IOException

	{

		PrintStream Log = new PrintStream(new FileOutputStream("Logs.txt"));
		RequestSpecBuilder RS = new RequestSpecBuilder()
				.setBaseUri(GetURL("StgURL"))
				.addHeader("Content-Type", "application/json")
				.addHeader("x-device-id", "wewef343rwsw33434343fsfs")
				.addHeader("x-api-client", "CEPQWJEEl8AZgYuyioUiVX6f0vuUwh7r0j3cSp3m")
				.addHeader("x-platform", "iOS")
				.addHeader("x-country", "IN")
				//.addHeader("x-api-token", UserValidation_StepDefination.Token) //Incase need to send Token by default as Header 
				.addFilter(RequestLoggingFilter
				.logRequestTo(Log))
				.addFilter(ResponseLoggingFilter
				.logResponseTo(Log))
				.setContentType(ContentType.JSON);

				req = RS.build();
		
		return req;

	}

	public static String GetURL(String Key) throws IOException

	{

		Properties prop = new Properties();
		FileInputStream URL = new FileInputStream(
				"/Users/kuldeepsingh/git/API_RestAssured_Framework/API_FrameWork/src/test/java/Resources/Global.properties");
		prop.load(URL);
		return prop.getProperty(Key);

	}

	public String getJsonPath(Response response, String Key)

	{

		String resp = response.asString();
		JsonPath JS = new JsonPath(resp);
		return JS.get(Key).toString();

	}

}
