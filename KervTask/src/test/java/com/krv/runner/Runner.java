package com.krv.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",features = {"src/test/resources/FeatureFiles"}, glue = {"com.krv.stepdef"},
        plugin = { "pretty",
                "html:target/output/cucumber-reports.html","rerun:target/failedrerun.txt"}, dryRun = false, monochrome = true)



public class Runner extends AbstractTestNGCucumberTests {


}



