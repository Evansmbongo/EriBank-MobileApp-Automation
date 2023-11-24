import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    AndroidDriver driver;
    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    @AndroidFindBy(id="com.experitest.ExperiBank:id/usernameTextField")
    private WebElement usernameField;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    private  WebElement passwordField;
    @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
    private WebElement loginButton;

    public void clickOkButton(){
        okButton.click();
    }
    public void setUsernameField(String username){
        usernameField.sendKeys(username);
    }
    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }



}
