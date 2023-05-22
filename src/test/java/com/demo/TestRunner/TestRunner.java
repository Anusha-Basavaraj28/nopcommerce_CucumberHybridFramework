package com.demo.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/",
                 glue = "com.demo.StepDefinitions",
                 monochrome = true,
                 dryRun = false,
                 plugin = {"pretty","html:target/cucumber-reports"},
                 tags = "@sanity"
                 )
public class TestRunner {
// dryRun = false--->make it true when you want to cross check whether all the steps are implemented or not.
	// make it false if you want to run.
}
