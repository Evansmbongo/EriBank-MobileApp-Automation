import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Double.TYPE;
import static java.lang.Double.parseDouble;

public class BalancePage {
    AndroidDriver driver;
    public BalancePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
    private WebElement paymentButton;
    @AndroidFindBy(className = "com.experitest.ExperiBank:id/logoutButton")
    private WebElement logoutButton;
//    @AndroidFindBy(className = "android.widget.TextView[0]")
//    public WebElement balance;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@index='0'])[2]")
    public WebElement balance;

    public void clickPayment(){
        paymentButton.click();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }
    public double checkBalance(){
        String balanceText = balance.getText();
        double balanceNumber = parseDouble(balanceText.replaceAll("[a-zA-Z$:()]", ""));
        return balanceNumber;
    }
}
