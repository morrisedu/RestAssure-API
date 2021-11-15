package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt" , //@target/rerun.txt will instruct cucumber to use the content of rerun.txt as features to run
        glue = "com/many/steps_definitions",
        plugin = {"pretty", "html:target/failed_cucumber.html"} // optionally
)
public class FailedTestRunner {
}
