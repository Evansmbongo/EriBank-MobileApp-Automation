import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
    @Test
    public void LoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOkButton();
        loginPage.setUsernameField("company");
        loginPage.setPasswordField("company");
        loginPage.clickLoginButton();
        Thread.sleep(3000);
    }
}
