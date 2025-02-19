package com.saucedemo.v1.index.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/saucedemo/v1/index/features",
        glue = "com/saucedemo/v1/index/steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class TestRunner {
}
