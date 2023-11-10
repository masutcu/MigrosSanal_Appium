package stepDef;

import io.cucumber.java.en.Given;
import utilities.Driver;
import utilities.ReusableMethods;

public class FirstStepDef {


    @Given("user goes main page")
    public void userGoesMainPage() {
        Driver.getDriver();
        ReusableMethods.wait(3);
    }
}
