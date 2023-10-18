package stepDef;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.androidScreen.LoginScreen;
import screens.androidScreen.MainSubTitleScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class SubtitleStepDef extends ReusableMethods {
    MainSubTitleScreen locate=new MainSubTitleScreen();

    @Given("user taps on {string} button")
    public void userTapsOnButton(String text) {
    tapOnElementWithText(text);
    wait(1);
    }


    @And("user closes the opened adv")
    public void userClosesTheOpenedAdv() {
        tapOnWithPoint(Driver.getDriver(), 1005, 256);
    }

    @Then("user taps on canpaigns {string} in order")
    public void userTapsOnCanpaignsInOrder(String title) {

    Driver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='"+title+"']")).click();
    wait(1);

    }

    @And("user enters the opened adv")
    public void userEntersTheOpenedAdv() {
        tapOnWithPoint(Driver.getDriver(), 530, 2219);
        wait(1);
    }

    @Then("verify that the  opened page {string} is correct")
    public void verifyThatTheOpenedPageIsCorrect(String title) {

        System.out.println("advTitle = " + locate.advTitle.getText());
        Assert.assertTrue(locate.advTitle.getText().toLowerCase().contains(title.toLowerCase()));
        wait(1);
    }

    @And("user taps on return button")
    public void userTapsOnReturnButton() {
        locate.reIcon.click();
    }
}
