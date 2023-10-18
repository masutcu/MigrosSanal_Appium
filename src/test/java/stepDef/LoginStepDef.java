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
        tapOn(locate.uyeOlGirisButton);
    }

    @Then("user taps on _uyeOl_ button")
    public void userTapsOn_uyeOl_Button() {
        tapOn(locate.uyeOlButton);
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
            } wait(1);

        }
        tapOnWithPoint(Driver.getDriver(),517,871);

    }


    @And("verify user passes the sms page")
    public void verifyUserPassesTheSmsPage() {
        Assert.assertTrue(locate.smsPage.isDisplayed());
    }

    @Then("user taps on _girisYap_ button")
    public void userTapsOn_girisYap_Button() {
        tapOn(locate.girisYapButton);
    }
    @Then("user enters telnumber {string}")
    public void user_enters_telnumber(String string) {
        locate.telNoSignUp.sendKeys("5531610100");
    }
    @Then("user enters mailAdress {string}")
    public void user_enters_mail_adress(String string) {
        locate.eMailSignUp.sendKeys("masutcu@gmail.com");
    }
    @Then("user selects uyelikSozlesmesi checkBox")
    public void user_selects_uyelik_sozlesmesi_check_box() {
        locate.uyelikSozlesmesiCB.click();
    }
    @Then("Verify that uyelikSozlesmesi box checked")
    public void verify_that_uyelik_sozlesmesi_box_checked() {
        wait(1);
        System.out.println("uyelikSozlesmesiCB = " + locate.uyelikSozlesmesiCB.getAttribute("checked"));
        Assert.assertEquals("true",locate.uyelikSozlesmesiCB.getAttribute("checked"));

    }
    @Then("user selects kullanıcıIzni checkBox")
    public void user_selects_kullanıcı_izni_check_box() {
       locate.iletisimIzniCB.click();
    }
    @Then("Verify that kullanıcıIzni box checked")
    public void verify_that_kullanıcı_izni_box_checked() {
        wait(1);
        System.out.println("iletisimIzniCB = " + locate.iletisimIzniCB.getAttribute("checked"));
        Assert.assertEquals("true",locate.iletisimIzniCB.getAttribute("checked"));
    }

    @Then("user clicks uyeOl button")
    public void userClicksUyeOlButton() {
        locate.uyeOlButton.click();
    }


}
