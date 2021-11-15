package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        publish = false,
        glue = "com/many/steps_definitions",
        plugin = {"html:target/test_report.html",
                "json:target/test_report.json", "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target"},
        dryRun = false
        //tags = "@web-ui and @google"
)

public class TestRunner {
}
