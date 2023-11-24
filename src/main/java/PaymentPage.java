import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Double.parseDouble;

public class PaymentPage {
    AndroidDriver driver;
    public PaymentPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/phoneTextField")
    private WebElement phoneField;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/nameTextField")
    private WebElement nameField;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/amountLabel")
    public WebElement amount;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/amount")
    private WebElement slider;
    @AndroidFindBy(id="com.experitest.ExperiBank:id/countryButton")
    private WebElement selectCountry;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryTextField")
    public WebElement countryField;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
    private WebElement paymentButton;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/cancelButton")
    private WebElement cancelButton;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement confirmYesButton;

    public void setPhoneField(String phone){
        phoneField.sendKeys(phone);
    }
    public void setNameField(String name){
        nameField.sendKeys(name);
    }
    public void setSlider(double number){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)slider).getId(),
                "direction", "right",
                "percent", number
        ));
    }
    public void setSelectCountry(AndroidDriver driver, String country){
        selectCountry.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new " +
                "UiSelector().text(\"" + country + "\"))")).click();
    }
    public String selectedCountry(){
        String countryName = countryField.getText();
        return countryName;
    }
    public void clickPaymentButton(){
        paymentButton.click();
    }
    public void clickCancelButton(){
        cancelButton.click();
    }
    public void clickYesButton(){
        confirmYesButton.click();
    }
    public double getAmount(){
        String amountText = amount.getText();
        double amountNumber = parseDouble(amountText.replaceAll("[a-zA-Z$:()]", ""));
        return amountNumber;
    }
}
