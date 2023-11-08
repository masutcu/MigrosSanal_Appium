package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductScreen extends MainScreen{
    @FindBy(id = "com.inomera.sm:id/textInputEditText")
    public WebElement searchBox;
    @FindBy(id = "com.inomera.sm:id/searchTextInputEditText")
    public WebElement searchItem;

    @FindBy(id = "com.inomera.sm:id/product_name_text_view")
    public List<WebElement> products;

    @FindBy(id = "com.inomera.sm:id/tvSort")
    public WebElement sortButton;

    @FindBy(id = "com.inomera.sm:id/buttonOrderProducts")
    public WebElement uygulaButton;

    @FindBy(id = "com.inomera.sm:id/final_price_text_view")
    public List<WebElement> prices;

    @FindBy(id = "com.inomera.sm:id/microphoneImageButton")
    public WebElement microphone;

    @FindBy(id = "com.inomera.sm:id/tvFilter")
    public WebElement filterButton;

    @FindBy(className = "android.widget.CheckBox")
    public WebElement indirimCheckBox;

    @FindBy(id = "com.inomera.sm:id/buttonViewProducts")
    public WebElement OKButton;

    @FindBy(className = "android.widget.CheckBox")
    public List<WebElement> markalarCheckBox;

    @FindBy(id = "com.inomera.sm:id/btn_view_products")
    public WebElement viewProductButton;









}
