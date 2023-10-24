package stepDef;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    @And("Verify that the product displayed is correct")
    public void verifyThatTheProductDisplayedIsCorrect() {
        System.out.println("locate.products.size() = " + locate.products.size());
        for (int i = 0; i < locate.products.size(); i++) {
            System.out.println("productname = " + locate.products.get(i).getText());
            Assert.assertTrue(locate.products.get(i).getText().toLowerCase().contains("çay"));
        }


    }

    @And("user taps on sortButton")
    public void userTapsOnSortButton() {
        tapOn(locate.sortButton);
    }

    @And("Verify that the products are sorted from {string}")
    public void verifyThatTheProductsAreSortedFrom(String sortBy) {
        validateProductsSortingByPrice(sortBy);



    }

    @And("user taps on uygulaButton")
    public void userTapsOnUygulaButton() {
        locate.uygulaButton.click();
        wait(2);
    }


    @And("user taps on {string} option")
    public void userTapsOnOption(String sortBy) {
        String locateOption="//android.widget.RadioButton[@text='"+sortBy+"']";
        Driver.getDriver().findElement(By.xpath(locateOption)).click();
        wait(2);
    }
}
