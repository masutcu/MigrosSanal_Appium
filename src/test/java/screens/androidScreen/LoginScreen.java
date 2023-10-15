package screens.androidScreen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class LoginScreen extends MainScreen{

    @FindBy(id = "com.inomera.sm:id/imageViewProfile")
    public WebElement  loginButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Üye Ol veya Giriş Yap']")
    public WebElement uyeOlGirisButton;
    @FindBy(xpath = "//android.widget.Button[@text='Giriş Yap']")
    public WebElement girisYapButton;




}
