import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class BaseTest {
   AndroidDriver driver;
    @BeforeMethod
    public void configureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 Pro 1");
        options.setApp("C:/Users/EvansMbongo/Desktop/Tests/EriBank/src/main/resources/EriBank.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }
}
