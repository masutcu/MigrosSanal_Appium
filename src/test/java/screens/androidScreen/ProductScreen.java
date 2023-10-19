package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductScreen extends MainScreen{
    @FindBy(id = "com.inomera.sm:id/textInputEditText")
    public WebElement searchBox;
    @FindBy(id = "com.inomera.sm:id/searchTextInputEditText")
    public WebElement searchItem;



}
