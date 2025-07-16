package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onlineBankingMenu")
    WebElement onlineBankingLink;

    @FindBy(id = "feedback")
    WebElement feedbackLink;

    @FindBy(id = "transfer_funds_link")
    WebElement transferFundsLink;



    public void clickOnFeedbackLink() {
        wait.until(ExpectedConditions.elementToBeClickable(feedbackLink)).click();
    }

    public void clickOnlineBanking() {
        wait.until(ExpectedConditions.elementToBeClickable(onlineBankingLink)).click();
    }


    public void clickOnTransferFundsLink () {
        transferFundsLink.click();
    }
}
