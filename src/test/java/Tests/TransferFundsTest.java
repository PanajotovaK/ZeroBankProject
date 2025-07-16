package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OnlineBankingPage;
import Pages.TransferFundsPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TransferFundsTest extends BaseTest {

    @BeforeMethod

    public void pageSetUp (){
        driver.get("http://zero.webappsecurity.com");

        loginPage = new LoginPage();
        homePage = new HomePage();
        onlineBankingPage = new OnlineBankingPage();
        transferFundsPage = new TransferFundsPage();



    }
    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
    }

    @Test

    public void SuccessTransferTest () {


        loginPage.login("username", "password");
        homePage.clickOnlineBanking();
        homePage.clickOnTransferFundsLink();
        transferFundsPage.selectFromAccountByValue("1");
        transferFundsPage.selectToAccountByValue("1");
        transferFundsPage.enterAmount("500");
        transferFundsPage.enterDescription("Transfer");
        transferFundsPage.clickOnContinueBtn();
        transferFundsPage.clickOnSubmitBtn();

        assertTrue(transferFundsPage.isOnConfirmPage(),
                "Expected confirmation page header was not displayed: 'Transfer Money & Make Payments - Confirm'");

        assertTrue(transferFundsPage.isTransactionSuccessful(),
                "Expected success message was not displayed: 'You successfully submitted your transaction.'");


    }

    @Test
    public void TransferFunds_CannotContinueWithEmptyFields() {

        loginPage.login("username", "password");

        homePage.clickOnlineBanking();
        homePage.clickOnTransferFundsLink();

        transferFundsPage.selectFromAccountByValue("1");
        transferFundsPage.selectToAccountByValue("1");

        transferFundsPage.clickOnContinueBtn();

        assertFalse(transferFundsPage.isOnConfirmPage(),
                "Should NOT navigate to confirmation page when required fields are empty.");
    }


}
