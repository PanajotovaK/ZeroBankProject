package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BaseTest {

    public TransferFundsPage () {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "tf_fromAccountId")
    WebElement fromAccountDropdown;

    @FindBy(id = "tf_toAccountId")
    WebElement toAccountDropdown;

    @FindBy(id = "tf_amount")
    WebElement amountField;

    @FindBy(id = "tf_description")
    WebElement descriptionField;

    @FindBy(css = "button.btn.btn-primary:contains('Continue')")
    WebElement continueBtn;

    @FindBy(css = "button.btn.btn-primary:contains('Submit')")
    private WebElement submitButton;


    @FindBy(css = "h2.board-header")
    WebElement confirmPageHeader;

    @FindBy(css = "div.alert.alert-success")
    WebElement successMessage;

    public void selectFromAccountByValue(String value) {
        wait.until(ExpectedConditions.visibilityOf(fromAccountDropdown));
        Select select = new Select(fromAccountDropdown);
        select.selectByValue(value);
    }

    public void selectToAccountByValue(String value) {
        wait.until(ExpectedConditions.visibilityOf(toAccountDropdown));
        Select select = new Select(toAccountDropdown);
        select.selectByValue(value);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountField));
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void clickOnContinueBtn () {
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();


    }
    public void clickOnSubmitBtn () {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public boolean isOnConfirmPage() {
        wait.until(ExpectedConditions.visibilityOf(confirmPageHeader));
        return confirmPageHeader.getText().trim().equals("Transfer Money & Make Payments - Confirm");
    }

    public boolean isTransactionSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText().trim().equals("You successfully submitted your transaction.");
    }


}
