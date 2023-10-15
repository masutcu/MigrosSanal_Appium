package stepDef;

import io.cucumber.java.en.Given;
import utilities.Driver;

public class firstStepDef {


    @Given("user goes main page")
    public void userGoesMainPage() {Driver.getDriver();
    }
}
