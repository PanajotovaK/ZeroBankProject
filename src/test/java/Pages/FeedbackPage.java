package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FeedbackPage extends BaseTest {

    public FeedbackPage () {
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "subject")
    WebElement subjectField;

    @FindBy(id = "comment")
    WebElement commentField;

    @FindBy(name = "submit")
    WebElement submitBtn;


    @FindBy(id = "feedback-title")
    WebElement successMsg;

    public void enterName (String name) {
       nameField.clear();
       nameField.sendKeys((name));
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    public void enterComment (String comment) {
        commentField.clear();
        commentField.sendKeys(comment);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }


    public boolean isSuccessMsgDisplayed () {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();

    }
}
