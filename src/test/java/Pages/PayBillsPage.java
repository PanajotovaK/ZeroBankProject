package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BaseTest {

    public PayBillsPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "sp_amount")
    WebElement amountField;

    @FindBy(id = "sp_date")
    WebElement dateField;

    @FindBy(id = "pay_saved_payees")
    WebElement payBtn;

    @FindBy(id = "alert_content")
    WebElement successMsg;

    public void enterAmount (String amount) {
        amountField.sendKeys(amount);
    }

    public void enterDate(String date) {
        dateField.sendKeys(date);
    }

    public void clickPay() {
        payBtn.click();
    }

    public String getSuccessMsg () {
       return successMsg.getText();
    }
}
