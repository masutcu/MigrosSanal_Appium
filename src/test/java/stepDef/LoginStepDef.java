package stepDef;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screens.androidScreen.LoginScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class LoginStepDef extends ReusableMethods {
   LoginScreen locate=new LoginScreen();

    @Given("user taps on login button")
    public void userTapsOnLoginButton() {
        waitToBeVisible(locate.loginButton, Duration.ofSeconds(5));
        locate.loginButton.click();

    }

    @Then("user taps on _uyeOlVeyaGirisYap_ text")
    public void userTapsOn_uyeOlVeyaGirisYap_Text() {
        wait(2);
        locate.uyeOlGirisButton.click();
    }

    @Then("user taps on _uyeOl_ button")
    public void userTapsOn_uyeOl_Button() {
        wait(2);
        locate.girisYapButton.click();
    }

    @And("user taps on telNumber input field")
    public void userTapsOnTelNumberInputField() {
        tapOnWithPoint(Driver.getDriver(),500,670);
    }
}
