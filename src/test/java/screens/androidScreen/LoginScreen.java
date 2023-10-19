package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class LoginScreen extends MainScreen{

    @FindBy (id = "com.inomera.sm:id/imageViewProfile")
    public WebElement  loginButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Üye Ol veya Giriş Yap']")
    public WebElement uyeOlGirisButton;
    @FindBy(xpath = "//android.widget.Button[@text='Giriş Yap']")
    public WebElement girisYapButton;
    @FindBy(xpath = "//android.widget.Button[@text='Üye Ol']")
    public WebElement uyeOlButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Telefonunu Doğrula']")
    public WebElement smsPage;
    @FindBy(xpath = "//android.widget.EditText[@text='Telefon Numarası']")
    public WebElement telNoSignUp;
    @FindBy(xpath = "//android.widget.EditText[@text='E-posta']")
    public WebElement eMailSignUp;
    @FindBy(id = "com.inomera.sm:id/privacyAgreementCheckBox")
    public WebElement  uyelikSozlesmesiCB;
    @FindBy(id = "com.inomera.sm:id/communicationAgreementCheckBox")
    public WebElement  iletisimIzniCB;










}
