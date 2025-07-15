package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage extends BaseTest {

    public OnlineBankingPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pay_bills_link")
    WebElement payBillsLink;

    public void clickPayBills() {
        payBillsLink.click();
    }
}
