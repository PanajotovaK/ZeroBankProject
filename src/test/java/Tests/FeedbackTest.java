package Tests;

import Base.BaseTest;
import Pages.FeedbackPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends BaseTest {

    FeedbackPage feedbackPage;
    HomePage homePage;

    @BeforeClass
    public void setUp() {

        super.setUp();
        homePage = new HomePage();
        feedbackPage = new FeedbackPage();

        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickOnFeedbackLink();
    }

    @Test
    public void sendFeedbackSuccessfully() {
        feedbackPage.enterName("Kristina");
        feedbackPage.enterEmail("kristina@test.com");
        feedbackPage.enterSubject("Automated Feedback");
        feedbackPage.enterComment("This is an automated feedback test.");
        feedbackPage.clickSubmit();

        Assert.assertTrue(feedbackPage.isSuccessMsgDisplayed(), "Success message is not displayed.");
    }
}
