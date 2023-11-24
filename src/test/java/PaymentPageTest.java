import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaymentPageTest extends BaseTest{
    @Test
    public void PaymentTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        BalancePage balancePage = new BalancePage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        loginPage.clickOkButton();
        loginPage.setUsernameField("company");
        loginPage.setPasswordField("company");
        loginPage.clickLoginButton();

        double amountBefore = balancePage.checkBalance();
        balancePage.clickPayment();

        paymentPage.setPhoneField("0241234567");
        paymentPage.setNameField("Dax");
        paymentPage.setSlider(0.20);

        double sentAmount = paymentPage.getAmount();

        paymentPage.setSelectCountry(driver,"Russia");
        Assert.assertEquals(paymentPage.selectedCountry(),"Russia", "Wrong country selected");
        paymentPage.clickPaymentButton();
        paymentPage.clickYesButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(balancePage.balance));

        double remaingBalance =  amountBefore - sentAmount;
        Assert.assertEquals(remaingBalance, balancePage.checkBalance(), "Amounts does not match");
    }
}
