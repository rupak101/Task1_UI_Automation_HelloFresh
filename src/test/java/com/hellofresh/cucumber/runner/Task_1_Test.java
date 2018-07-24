package com.hellofresh.cucumber.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue = {"com.hellofresh.cucumber.steps.gherkin"},features = "src/test/resources/features/task1UIAutomation.feature",format={"html:target/cucumber-htmlreport"})
public class Task_1_Test {
}
