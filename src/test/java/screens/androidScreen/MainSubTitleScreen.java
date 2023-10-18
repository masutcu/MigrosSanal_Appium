package screens.androidScreen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainSubTitleScreen {

    @FindBy(className = "android.widget.Button")
    public List<WebElement> canpaignTitle;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.inomera.sm:id/st_close_button']")
    public WebElement closeAdv;
    @FindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement advTitle;
    @FindBy(className = "android.widget.ImageButton")
    public WebElement reIcon;






}
