package com.smartdec.appscreener.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.smartdec.appscreener.steps"},
        features = {"src/test/resources/"},
        tags = ""
)
public class CucumberRunnerTest {

}