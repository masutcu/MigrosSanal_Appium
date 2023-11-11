package utilities;


import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;


import static java.lang.Double.parseDouble;

public class ReusableMethods {

    public static void tapOnElementWithText(String text) {
        List<WebElement> mobileElementList = Driver.getDriver().findElements(By.className("android.widget.TextView"));
        for (WebElement page: mobileElementList) {
            if (page.getText().equalsIgnoreCase(text)){
                page.click();
            }else{
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<WebElement> mobileElementList = Driver.getDriver().findElements(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        for (WebElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, Duration.ofSeconds(10));
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tapOn(WebElement element) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.sendKeys(text);
    }

    public static void enterText(WebElement element, String text, boolean needClear) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static boolean isElementPresent(WebElement webElement) {
        boolean elementFound = false;
        waitToBeVisible(webElement, Duration.ofSeconds(10));
        if (webElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    //Duration sınıfına değer atanırken Duration.ofSeconds() veya Duration.ofMinutes() kullanılır.
    public static void waitToBeVisible(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getDriver();
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))"));

        tapOn(driver.findElement(By.xpath("//android.widget.TextView[@text='" + elementText + "']")));
    }
    public static void tapOnWithPoint(AppiumDriver driver, int x, int y) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));


    }


    public static void tap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void doubleTap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    public static void longTap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1).
                addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement)).
                addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                addAction(new Pause(finger1, Duration.ofSeconds(4))).
                addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void scroll(AppiumDriver driver,  int scroll) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2 ;
        int startY = size.getHeight() / 2 ;
        int endX = startX;
        int endY = (int) (size.getHeight()*0.25);
        //buradaki 0,25 şu şekildedir; imleç ekranın ortasında yani 0,50 de,
        // y ekseninde 0,25 seçtiğimizde 0,50 den 0,25 e çekiyor yani aşağı  kayıyor.
        // Eğer 0,75 deseydik ters yönde  kaydıracaktı. Ne kadar kaydıracağı ise değişiyor.


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        for (int i = 0; i <scroll ; i++) {
            Sequence sequence = new Sequence(finger1,1).
                    addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY)).
                    addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                    addAction(new Pause(finger1, Duration.ofMillis(100))).
                    addAction(finger1.createPointerMove(Duration.ofMillis(300),PointerInput.Origin.viewport(),endX,endY)).
                    addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));}
        Thread.sleep(3000);
    }

    //Sağa kaydırma
    public static void swipeMethod(AppiumDriver driver, WebElement element, int scroll) throws InterruptedException {
        int centerY=element.getRect().y+(element.getSize().height/2);
        double startX= element.getRect().x+(element.getSize().width*0.9);
        double endX= element.getRect().x+(element.getSize().width*0.1);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        for (int i = 0; i <scroll ; i++) {
            Sequence sequence = new Sequence(finger1,1).
                    //move finger  into starting position
                    addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), (int) startX, centerY)).
                    //finger comes down into contact with screen- mause sol click bas
                    addAction(finger1.createPointerDown(0)).
                    //break time
                    addAction(new Pause(finger1, Duration.ofMillis(500))).
                    //finger moves to end position
                    addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),(int)endX,centerY)).
                    //get up finger from screen - mause sol click kaldır
                    addAction(finger1.createPointerUp(0));
                    //break time
                    //addAction(new Pause(finger1, Duration.ofMillis(500)));

                    driver.perform(Collections.singletonList(sequence));}

        Thread.sleep(3000);
    }

    public static void dragAndDrop(AppiumDriver driver, WebElement element1, WebElement element2){

        Point sourceCenter = getCenterOfElement(element1.getLocation(), element1.getSize());
        Point targetCenter = getCenterOfElement(element2.getLocation(), element2.getSize());

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger,1).
                addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter)).
                addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                addAction(new Pause(finger, Duration.ofMillis(200))).
                addAction(finger.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), targetCenter)).
                addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterOfElement(Point location, Dimension size){
        return new Point(location.getX() + size.getWidth() /2,
                location.getY() + size.getHeight() /2);
    }

    public static  void tabOnElementWithText(String text) throws InterruptedException {

        List<WebElement> elements = Driver.getDriver().findElements(AppiumBy.className("android.widget.TextView"));

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
            if (element.getText().contains(text)) {
                System.out.println("element.getText()111 = " + element.getText());
                element.click();
                break;
            } else ReusableMethods.scroll(Driver.getDriver(), 1);

        }

    }

    public static void backToPreScreen(){
        Driver.getDriver().navigate().back();
    }

    /**
     * Bu method locate alanlarında class tag name i aynı olan elementlerin attirubute isimlerinde farklılık varsa
     * farklı olan kısımlarını text parametresi ile locate alanına bir loop içinde ekleyip,
     * tek locate ile bütün elementleri gezmemizi sağlar. Byrada gezilen elementlerin assertion ları yapılmaktadır.
     * @param text :buraya attirubute alanınıdaki farklı text ler yazılır.
     * @throws InterruptedException
     */
    public static  void isElementVisibleWithText(String text) throws InterruptedException {

        List<WebElement> elements = Driver.getDriver().findElements(AppiumBy.className("android.widget.TextView"));

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
            if (element.getText().contains(text)) {
                System.out.println("element.getText()111 = " + element.getText());

                Assert.assertTrue(isElementPresent(element));
                break;
            } else scroll(Driver.getDriver(), 1);
            break;
        }

    }
    public static void getScreenshot() throws IOException {
        //after verification take screenshot
        //I use this code to take a screenshot when needed
        // naming the screenshot with the current date to avoid duplication

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + ".png";
        File finalDestination = new File(target);

        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
    }
    public static void validateCompabilitiyOfSubTitleWithTheTitle(String subTitle, String title) throws IOException {
        //Title alanı birden fazla mainword içeriyorsa  ayırıyoruz
        String[] titleElements = title.split(" ");
        for (int i = 0; i < titleElements.length; i++) {
            System.out.println("subtitle :" + subTitle);
            System.out.println("i :" + titleElements[i]);
            System.out.println("i+1 :" + titleElements[i + 1]);
            if (subTitle.contains(titleElements[i])) {
                Assert.assertTrue(subTitle.contains(titleElements[i]));
                System.out.println("sub title :" + subTitle + " başlık " + titleElements[i] + " kapsıyor");
                break;
            } else if (subTitle.contains(titleElements[i + 1])) {
                Assert.assertTrue(subTitle.contains(titleElements[i + 1]));
                System.out.println("sub title :" + subTitle + " başlık " + titleElements[i + 1] + " kapsıyor");
                break;
            } else System.out.println("subtitle :" + subTitle + " başlık değerlerini KAPSAMIYOR");
            getScreenshot();
            Assert.assertTrue(false);
        }
    }

    /**
     * Bu method Sıralama seçenekleri arasında 'Pahalıdan Ucuza' veya 'Ucuzdan Pahalıya'
     * şeklindeki parametreler ile sıralanan ürünlerin doğru şekilde görüntülenip görüntülenmediğini doğrular
     * @param option alanına 'Pahalıdan Ucuza' veya 'Ucuzdan Pahalıya' gelmelidir.
     */
    public static void validateProductsSortingByPrice(String option)  {
        List<WebElement> priceList1= Driver.getDriver().findElements(By.id(("com.inomera.sm:id/final_price_text_view")));
        int sizeOfList=priceList1.size();


        if(option.equals("Önce En Düşük Fiyat")){


            for (int n = 0; n < priceList1.size()-1; n++) {
                String price1 = priceList1.get(n).getText().replace("TL","").replace(",",".").trim();
                System.out.println("price1 = " + price1);
                String price2 = priceList1.get(n+1).getText().replace("TL","").replace(",",".").trim();
                System.out.println("price2 = " + price2);
                double first= parseDouble(price1);
                double second= parseDouble(price2);
                Assert.assertTrue(first<=second);

            }

        } else if (option.equals("Önce En Yüksek Fiyat")) {



            for (int n = 0; n < priceList1.size()-1; n++) {
                String price1 = priceList1.get(n).getText().replace("TL","").replace(",",".").trim();
                System.out.println("price1 = " + price1);
                String price2 = priceList1.get(n+1).getText().replace("TL","").replace(",",".").trim();
                System.out.println("price2 = " + price2);
                double first= parseDouble(price1);
                double second= parseDouble(price2);
                Assert.assertTrue(first>=second);

            }
        } else System.out.println("Parametreniz hatalı olabilir, Kontrol edin");

    }


    /**
     * Bu metot sayfadaki ürünlerin texlerini tek tek alıp Set içine koyar. Scroll yaparak aşağıya iner.
     * Son ürünü de aldıktan sonra kapanır.
     * @param locate Ürün sayısını gösteren text elementinin locate'dir. Xpath olarak verirseniz metinden
     *               sadece sayıyı alıp Set'in size ile karşılaştırır.
     * @throws InterruptedException
     */
    public static void urunDogrula(String locate) throws InterruptedException {
        Set<String> elements = new HashSet();
        List<WebElement> list = null;
        String count = Driver.getDriver().findElement(By.xpath(locate)).getAttribute("text");
        Integer expectedElementSize = Integer.parseInt(count.replaceAll("[^0-9]", ""));
        System.out.println("count = " + expectedElementSize);
        Integer actualElementSize = -1;

        int size=0;
        do {
            for(size = 0; size < 4; ++size) {
                try {
                    list = Driver.getDriver().findElements(By.xpath("//android.widget.TextView[@resource-id='com.mobisoft.kitapyurdu:id/textViewProductName']"));
                    elements.add(((WebElement)list.get(size)).getAttribute("text"));
                } catch (Exception var7) {
                }
            }

            if (expectedElementSize.equals(actualElementSize)) {
                break;
            }

            scroll(Driver.getDriver(), 1);
            actualElementSize = elements.size();


        } while(actualElementSize != expectedElementSize);
        System.out.println("actualElementSize = " + actualElementSize);
        System.out.println("expectedElementSize = " + expectedElementSize);

        Assert.assertEquals(actualElementSize , expectedElementSize);
    }
        public static void openFileWithPowershall(String path){

            //powerShell açarak ses dosyamızı açıyoruz
            try {
                String sesDosyasiYolu = ""+path+""; // Ses dosyasının yolu
                ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "Start-Process", "-FilePath", sesDosyasiYolu, "-Wait");
                processBuilder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public static void typeWithKeyBoard(String word){

        for (char c : word.toCharArray()) {
            System.out.print("c : " + c);
            char a = Character.toUpperCase(c);
            // Varsayalım ki büyük harf karakter 'A' tuşuna basımını taklit etmek istiyorsunuz
            if (a == 'A') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.A));
            } else if (a == 'B') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.B));
            } else if (a == 'C') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.C));
            } else if (a == 'D') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.D));
            } else if (a == 'E') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.E));
            } else if (a == 'F') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.F));
            } else if (a == 'G') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.G));
            } else if (a == 'Ğ') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.G));
            } else if (a == 'H') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.H));
            } else if (a == 'I') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.I));
            } else if (a == 'İ') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.I));
            } else if (a == 'J') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.J));
            } else if (a == 'K') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.K));
            } else if (a == 'L') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.L));
            } else if (a == 'M') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.M));
            } else if (a == 'N') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.N));
            } else if (a == 'O') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.O));
            } else if (a == 'Ö') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.O));
            } else if (a == 'P') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.P));
            } else if (a == 'R') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.R));
            } else if (a == 'S') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.S));
            } else if (a == 'Ş') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.S));
            } else if (a == 'T') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.T));
            } else if (a == 'U') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.U));
            } else if (a == 'Ü') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.U));
            } else if (a == 'V') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.V));
            } else if (a == 'Y') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.Y));
            } else if (a == 'Z') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.Z));
            } else if (a == 'W') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.W));
            } else if (a == 'X') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.X));
            } else if (a == ' ') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.SPACE));
            } else if (a == ',') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.COMMA));
            } else if (a == '.') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.PERIOD));
            } else if (a == '-') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.MINUS));
            } else if (a == '+') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.PLUS));
            } else if (a == '@') {
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.AT));

            } else {
                System.out.println("karakter tanımlaması yapılmamış. ");

            }


        }

    }

    /**
     * Bu methoddaki keyboard tuş koordinatları ,
     * 6 inç boyutlu Android bir emulator cihaza göre yazılmıştır.
     * Cihaz değişiminde kodlar hata verecektir.
     * @param word
     */

    public static void typeWithKeyBoardByRobot(String word){
        for (char c : word.toCharArray()) {
            System.out.print("c : " + c);
            char a = Character.toUpperCase(c);
            // Varsayalım ki büyük harf karakter 'A' tuşuna basımını taklit etmek istiyorsunuz
            if (a == 'A') {
                tapOnWithPoint(Driver.getDriver(),114,1872);
            } else if (a == 'B') {
                tapOnWithPoint(Driver.getDriver(),642,2031);
            } else if (a == 'C') {
                tapOnWithPoint(Driver.getDriver(),434,2031);
            } else if (a == 'D') {
                tapOnWithPoint(Driver.getDriver(),330,1872);
            } else if (a == 'E') {
                tapOnWithPoint(Driver.getDriver(),276,1722);
            } else if (a == 'F') {
                tapOnWithPoint(Driver.getDriver(),434,1872);
            } else if (a == 'G') {
                tapOnWithPoint(Driver.getDriver(),545,1872);
            } else if (a == 'Ğ') {
                tapOnWithPoint(Driver.getDriver(),545,1872);
            } else if (a == 'H') {
                tapOnWithPoint(Driver.getDriver(),649,1872);
            } else if (a == 'I') {
                tapOnWithPoint(Driver.getDriver(),807,1708);
            } else if (a == 'İ') {
                tapOnWithPoint(Driver.getDriver(),807,1708);
            } else if (a == 'J') {
                tapOnWithPoint(Driver.getDriver(),753,1872);
            } else if (a == 'K') {
                tapOnWithPoint(Driver.getDriver(),857,1872);
            } else if (a == 'L') {
                tapOnWithPoint(Driver.getDriver(),969,1872);
            } else if (a == 'M') {
                tapOnWithPoint(Driver.getDriver(),861,2027);
            } else if (a == 'N') {
                tapOnWithPoint(Driver.getDriver(),753,2031);
            } else if (a == 'O') {
                tapOnWithPoint(Driver.getDriver(),915,1722);
            } else if (a == 'Ö') {
                tapOnWithPoint(Driver.getDriver(),915,1722);
            } else if (a == 'P') {
                tapOnWithPoint(Driver.getDriver(),1022,1722);
            } else if (a == 'R') {
                tapOnWithPoint(Driver.getDriver(),377,1722);
            } else if (a == 'S') {
                tapOnWithPoint(Driver.getDriver(),219,1872);
            } else if (a == 'Ş') {
                tapOnWithPoint(Driver.getDriver(),219,1872);
            } else if (a == 'T') {
                tapOnWithPoint(Driver.getDriver(),491,1722);
            } else if (a == 'U') {
                tapOnWithPoint(Driver.getDriver(),703,1722);
            } else if (a == 'Ü') {
                tapOnWithPoint(Driver.getDriver(),703,1722);
            } else if (a == 'V') {
                tapOnWithPoint(Driver.getDriver(),542,2027);
            } else if (a == 'Y') {
                tapOnWithPoint(Driver.getDriver(),596,1722);
            } else if (a == 'Z') {
                tapOnWithPoint(Driver.getDriver(),219,2022);
            } else if (a == 'W') {
                tapOnWithPoint(Driver.getDriver(),169,1722);
            } else if (a == 'X') {
                tapOnWithPoint(Driver.getDriver(),326,2031);
            } else if (a == ' ') {
                tapOnWithPoint(Driver.getDriver(),563,2188);
            } else if (a == ',') {
                tapOnWithPoint(Driver.getDriver(),219,2181);
            } else if (a == '.') {
                tapOnWithPoint(Driver.getDriver(),861,2181);
            } else if (a == '-') {
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),596,1880);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);

            } else if (a == '+') {
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),703,1883);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);
            } else if (a == '@') {
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),57,1876);
                wait(1);
                tapOnWithPoint(Driver.getDriver(),90,2185);
                wait(1);

            } else {
                System.out.println("karakter tanımlaması yapılmamış. ");

            }


        }

    }



    }




