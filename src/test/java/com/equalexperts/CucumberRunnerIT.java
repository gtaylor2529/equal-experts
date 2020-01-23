package com.equalexperts;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"com.equalexperts.stepdefs"},
    features = "src/test/resources/features/",
    plugin = {"json:target/cucumber/cucumber.json"})
public class CucumberRunnerIT {}
