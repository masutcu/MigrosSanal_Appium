package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty",
               // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", //Dependency eklenmeli
                "html:TestOutput/htmlReport/cucumberHooks.html",
                "json:target/json-reports/cucumber.json",
                "junit:TestOutput/htmlReport/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt"},
        features = "src/test/resources/features",
        glue = "stepDef",
        tags = "",

        dryRun = false)

public class Runner {
}
