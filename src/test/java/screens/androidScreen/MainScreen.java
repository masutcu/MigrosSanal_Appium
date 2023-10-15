package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class MainScreen {
    //diğer Screen class lar bu class a extend edilerek PageFactory metoduna gerek kalmayacak.
    public MainScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)), this);
    }
}
