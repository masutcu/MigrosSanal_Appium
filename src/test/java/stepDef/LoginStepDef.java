package stepDef;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.androidScreen.LoginScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Then("user enters own number {string}")
    public void userEntersOwnNumber(String telefon) {


        List number= new ArrayList<>();
        for (int i = 0; i < telefon.length(); i++) {
            char num1=telefon.charAt(i);
            number.add(num1);

        }number.stream().forEach(t-> System.out.print(t));
        System.out.println();


        for (int i = 0; i <number.size() ; i++) {
            String sıra=number.get(i).toString();
            System.out.println("numara : "+sıra);
            wait(1);
            switch (sıra) {
                case "1" : tapOnWithPoint(Driver.getDriver(),145,1715); break;
                case "2" : tapOnWithPoint(Driver.getDriver(),408,1715); break;
                case "3" : tapOnWithPoint(Driver.getDriver(),667,1715); break;
                case "4" : tapOnWithPoint(Driver.getDriver(),145,1874); break;
                case "5" : tapOnWithPoint(Driver.getDriver(),408,1874); break;
                case "6" : tapOnWithPoint(Driver.getDriver(),667,1874); break;
                case "7" : tapOnWithPoint(Driver.getDriver(),145,2015); break;
                case "8" : tapOnWithPoint(Driver.getDriver(),408,2015); break;
                case "9" : tapOnWithPoint(Driver.getDriver(),667,2015); break;
                case "0" : tapOnWithPoint(Driver.getDriver(),408,2174); break;
            } wait(2);

        }
        tapOnWithPoint(Driver.getDriver(),517,871);

    }


}
