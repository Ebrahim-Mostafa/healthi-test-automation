package cucumber.runner;

import BasePackage.BaseTest;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(monochrome = true,
        features = {"src/test/java/cucumber/features/NMSSunnyDay.feature"},
        glue = {"cucumber.steps"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, publish = true)
public class TestRunner extends BaseTest {

}
