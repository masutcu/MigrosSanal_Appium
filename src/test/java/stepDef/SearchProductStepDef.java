package stepDef;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import screens.androidScreen.ProductScreen;
import utilities.Driver;
import utilities.ReusableMethods;



public class SearchProductStepDef extends ReusableMethods {
    ProductScreen locate = new ProductScreen();
    @Given("user taps on searchBox")
    public void userTapsOnSearchBox() {

        locate.searchBox.click();
        wait(2);

    }


    @Then("user taps on search icon on keyboard")
    public void userTapsOnSearchIconOnKeyboard() {
      ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

       // tapOnWithPoint(Driver.getDriver(),991,2174);
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

    @When("user enters {string} in search box")
    public void userEntersInSearchBox(String text) {

        locate.searchItem.sendKeys(text);
        tapOn(locate.searchItem);
        wait(1);
    }

    @Given("user taps on microphone button")
    public void userTapsOnMicrophoneButton() {
        locate.microphone.click();
        wait(2);
    }

    @Then("loads sampleVoiceFile")
    public void loadsSampleVoiceFile() {
        openFileWithPowershall("voice.wav");

    }

    @And("user taps on filterButton")
    public void userTapsOnFilterButton() {
        locate.filterButton.click();
    }

    @Given("user select filter by {string}")
    public void userSelectFilterBy(String arg0) {
        String filterOption="//android.widget.TextView[@text='"+arg0+"']";
        Driver.getDriver().findElement(By.xpath(filterOption)).click();

    }

    @Then("user select checkBox and tap on Uygula button")
    public void userSelectCheckBoxAndTapOnUygulaButton() {
        locate.indirimCheckBox.click();
        wait(1);
        locate.OKButton.click();
        wait(1);
    }

    @Then("user select first {int} options")
    public void userSelectFirstOptions(int markaSayısı) {
        if(locate.markalarCheckBox.size()>=markaSayısı) {
            for (int i = 0; i < markaSayısı; i++) {
                locate.markalarCheckBox.get(i).click();
                wait(1);
            }
        }else locate.markalarCheckBox.get(0).click();

    }


    @And("user taps on OKButton")
    public void userTapsOnOKButton() {
        locate.OKButton.click();
        wait(1);
    }

    @And("user taps on OKButton again")
    public void userTapsOnOKButtonAgain() {
        locate.viewProductButton.click();
    }

    @When("user search {string} with keyboard")
    public void userSearchWithKeyboard(String kelime) {
        typeWithKeyBoard(kelime);

    }

    @When("user search {string} with keyboard by Robot")
    public void userSearchWithKeyboardByRobot(String word) {
        typeWithKeyBoardByRobot(word);
    }

    @And("verify keyboard appears on Screen")
    public void verifyKeyboardAppearsOnScreen() {
        System.err.println(((AndroidDriver) Driver.getDriver()).isKeyboardShown());
    }

    @Given("user taps on borcode icon")
    public void userTapsOnBorcodeIcon() {
        tapOn(locate.barcodeButton);
        wait(1);
    }

    @Then("verify device cam is open")
    public void verifyDeviceCamIsOpen() {

        Assert.assertTrue(locate.textBarkodIleUrunArama.isDisplayed());
        wait(1);


    }

    @And("verify frame Image View appeared")
    public void verifyFrameImageViewAppeared() {
        Assert.assertTrue(locate.frameImgView.isEnabled());

    }

    @Then("user taps on delivery")
    public void userTapsOnDelivery() {
        tapOn(locate.deliveryButton);
    }

    @Then("user enters delivery address")
    public void userEntersDeliveryAddress() {
        tapOn(locate.addressSearch);
        wait(1);
        locate.addressSearch.sendKeys("Kavaklı mahallesi Katip Celebi sokak No.19 Beylikdüzü İstanbul");
        wait(2);

    }

    @And("user selects suitable address option")
    public void userSelectsSuitableAddressOption() {
        locate.addressOptions.get(0).click();
    }

    @And("verify address from map")
    public void verifyAddressFromMap() {
        wait(5);
        String adres=locate.addressInfo.getText();
        System.out.println("adres = " + adres);
        Assert.assertTrue(adres.contains("Kavaklı"));
    }


    @Then("verify selected market on townView field")
    public void verifySelectedMarketOnTownViewField() {
        System.out.println("Selected Market = " + locate.townViewField.getText());
        Assert.assertTrue(locate.townViewField.getText().contains("GALA SOKAĞI"));
    }
}
