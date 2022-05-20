package Cucumberdemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/resources",glue= {"Cucumberdemo"},
plugin= {"pretty","json:JSONReport/target/JsonReport/report.json","junit:JUNITReport/target/JunitReport/report.xml","html:HTMLReport/target/htmlreport/report.html"}
	,tags="@smoke or @sanity or @Regression")
public class Runner {
	

}
