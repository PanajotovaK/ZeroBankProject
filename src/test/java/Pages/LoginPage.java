package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "signin_button")
    WebElement singInBtn;

    @FindBy(id = "user_login")
    WebElement usernameField;

    @FindBy(id = "user_password")
    WebElement passwordField;

    @FindBy(name = "submit")
    WebElement submitBtn;

    @FindBy(id = "user_remember_me")
    WebElement checkBoxRemberMe;

    public void clickSignin () {
        singInBtn.click();
    }

    public void enterUsername (String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit () {
        submitBtn.click();
    }

    public void login(String username, String password) {
        clickSignin();
        enterUsername(username);
        enterPassword(password);
        setCheckBoxRemberMe();
        clickSubmit();
        driver.navigate().back();
    }

    public void setCheckBoxRemberMe() {
        if (!checkBoxRemberMe.isSelected()) {
            checkBoxRemberMe.click();
        }
    }
}
