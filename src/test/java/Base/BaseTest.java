package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public HomePage homePage;
    public LoginPage loginPage;
    public OnlineBankingPage onlineBankingPage;
    public PayBillsPage payBillsPage;
    public FeedbackPage feedbackPage;
    public TransferFundsPage transferFundsPage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);


        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("disable-password-manager-reauthentication");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));


        WebDriverManager.chromedriver().setup();



        driver = new ChromeDriver(options);


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File targetFile = new File("screenshots/" + testName + ".png");
            FileUtils.copyFile(screenshot, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass

    public void teardown () {
        driver.quit();
    }

}
