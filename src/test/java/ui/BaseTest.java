package ui;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

abstract public class BaseTest {

    protected static WebDriverWait wait;
    protected static RemoteWebDriver driver;
    protected static ChromeOptions chromeOptions;

    public static void setUp() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Check if string {string1} is equal to string {string2}")
    public static void checkEqualString(String string1, String string2) {
        Assert.isTrue(string1.equals(string2), "Strings are not equal");
    }

    @BeforeEach
    public void init() throws MalformedURLException {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    public void sendToElement(By locator, String string) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(string);
    }

    public String getTextInElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator).getText();
    }
}
