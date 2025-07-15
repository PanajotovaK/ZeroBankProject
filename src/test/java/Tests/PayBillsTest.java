package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OnlineBankingPage;
import Pages.PayBillsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class PayBillsTest extends BaseTest {

    @BeforeMethod

    public void PageSetUp () {

        driver.get("http://zero.webappsecurity.com");



        loginPage = new LoginPage();
        homePage = new HomePage();
        onlineBankingPage = new OnlineBankingPage();
        payBillsPage = new PayBillsPage();

        loginPage.login("username", "password");

    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
    }

    @Test
    public void testPayBillSuccess () {
        homePage.clickOnlineBanking();
        onlineBankingPage.clickPayBills();

        payBillsPage.enterAmount("500");
        payBillsPage.enterDate("2025-07-15");
        payBillsPage.clickPay();

        String acctualMsg = payBillsPage.getSuccessMsg();

        Assert.assertTrue(acctualMsg.contains("The payment was successfully submitted."));
    }

}
