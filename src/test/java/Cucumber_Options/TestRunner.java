package Cucumber_Options;

import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/kuldeepsingh/git/API_RestAssured_Framework/API_FrameWork/src/test/java/Feature_Files", 
plugin = "json:target/jsonReports/Cucumber_Reports.json", 
glue = {"Step_Definations"},tags = {""})

public class TestRunner {

}
