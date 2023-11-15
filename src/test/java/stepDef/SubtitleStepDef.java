package stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import screens.androidScreen.MainSubTitleScreen;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.Swipe;

import java.util.Arrays;


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

       // System.out.println("advTitle = " + locate.advTitle.getText());
       // Assert.assertTrue(locate.advTitle.getText().toLowerCase().contains(title.toLowerCase()));

    }

    @And("user taps on return button")
    public void userTapsOnReturnButton() {
        locate.reIcon.click();
    }

    @Given("verify campaing page count")
    public void verifyCampaingPageCount() throws InterruptedException {
        System.out.println("locate.campaingPage.getText() = " + locate.campaingPageNum.getText());
        System.out.println("locate.campaingPage.getText().substring(2,4) = " + locate.campaingPageNum.getText().substring(2,4));
        int num=Integer.parseInt(locate.campaingPageNum.getText().substring(2,4));





    }

    @Then("user swipe all campaing screen")
    public void userSwipeAllCampaingScreen() throws InterruptedException {
        swipeMethod(Driver.getDriver(), locate.campaingPageImg,Integer.parseInt(locate.campaingPageNum.getText().substring(2,4))-1);
    }

    @And("verify last scrolable page is displayed")
    public void verifyLastScrolablePageIsDisplayed() {
        System.out.println("toplam sayfa alanı = " + locate.campaingPageNum.getText());
        String displayedPage=locate.campaingPageNum.getText().substring(0,2);
        System.out.println("görüntülenen sayfa = " + locate.campaingPageNum.getText().substring(0,2));
        String lastPage=locate.campaingPageNum.getText().substring(3,5);
        System.out.println("son sayfa sayısı = " + locate.campaingPageNum.getText().substring(3,5));

        Assert.assertTrue(displayedPage.equals(lastPage));



    }

    @Given("Scroll {int} times down on MainPage")
    public void scrollTimesDownOnMainPage(int arg0) throws InterruptedException {
        scroll(Driver.getDriver(),arg0);
    }
}
