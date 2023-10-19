package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import screens.androidScreen.MainScreen;
import screens.androidScreen.ProductScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class SearchProductStepDef extends ReusableMethods {
    ProductScreen locate = new ProductScreen();
    @Given("user taps on searchBox")
    public void userTapsOnSearchBox() {
        tapOn(locate.searchBox);
        wait(1);
    }

    @Given("user enters {string} in search input")
    public void userEntersInSearchInput(String arg0) {
        locate.searchItem.sendKeys(arg0);
        tapOn(locate.searchItem);
        wait(1);

    }
    @Then("user taps on search icon on keyboard")
    public void userTapsOnSearchIconOnKeyboard() {
        tapOnWithPoint(Driver.getDriver(),991,2174);
    }
}
