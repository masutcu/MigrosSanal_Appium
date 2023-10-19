package stepDef;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;

import static utilities.Driver.getDriver;
import static utilities.Driver.isAppiumServerRunning;

public class Hooks {
    public static AppiumDriverLocalService server;

/*

    @BeforeAll
    public static void openCMD() throws IOException{

        try{
            String command = "cmd /c start appium";
            //Starting the appium
            Process process= Runtime.getRuntime().exec(command);
            System.out.println("prosess is Alive "+process.isAlive());

        }catch (Exception e){
            System.out.println("Error : "+e);
        }
        ReusableMethods.wait(10);
    }
    */

    @Before
    public void setUp() throws InterruptedException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(30));

        try {
            server = AppiumDriverLocalService.buildService(builder);
        } catch (Exception e) {
            System.out.println("APPIUM SERVER NOT ASSIGN");
        }

        try {
            server.start();
        } catch (Exception e) {
            System.out.println("APPIUM SERVER NOT START");
        }


        int maxWaitTimeSeconds  = 120;
        int port = 4723;
        boolean serverStarted = false;

        for (int i = 0; i < maxWaitTimeSeconds; i += 5) {
            if (isAppiumServerRunning("localhost", port)) {
                serverStarted = true;
                break;
            } else {
                Thread.sleep(5000); // 5 saniye bekleyin ve tekrar kontrol edin
            }
        }

        if (serverStarted) {
            System.out.println("Appium sunucusu başarıyla başlatıldı ve bağlandı.");
        } else {
            System.out.println("Appium sunucusu başlatılamadı veya bağlantı sağlanamadı.");
        }

    }



    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        // Driver.quitAppiumDriver();
    }


    /* Allure dependency yi kaldırdık. çalışmıyor
    @AfterAll
    public static void openAllure() throws IOException{
        try{
            String command = "cmd /c allure serve allure-results";
            //Starting the appium
            Process process= Runtime.getRuntime().exec(command);
            System.out.println("prosess is Alive "+process.isAlive());

        }catch (Exception e){
            System.out.println("Error : "+e);
        }
        ReusableMethods.wait(10);

    }

 */
}
