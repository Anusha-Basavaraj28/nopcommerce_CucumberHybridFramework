package com.demo.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features//customer.feature",".//Features//login.feature"},
                 glue = "com.demo.StepDefinitions",
                 monochrome = true,
                 dryRun = false,
                 plugin = {"pretty","html:target/htmlReport"})
public class TestRunnerAddCustomer {
// dryRun = false--->make it true when you want to cross check whether all the steps are implemented or not.
	// make it false if you want to run.
}
