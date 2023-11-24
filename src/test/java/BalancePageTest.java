import org.testng.annotations.Test;

public class BalancePageTest extends BaseTest{
    @Test
    public void BalanceTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        BalancePage balancePage = new BalancePage(driver);

        loginPage.clickOkButton();
        loginPage.setUsernameField("company");
        loginPage.setPasswordField("company");
        loginPage.clickLoginButton();

        Thread.sleep(3000);
        balancePage.checkBalance();
        balancePage.clickPayment();

    }
}
