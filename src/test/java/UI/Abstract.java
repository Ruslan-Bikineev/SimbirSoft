package UI;

import java.net.URL;
import java.time.Duration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;


abstract public class Abstract {

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

    @BeforeEach
    public void init() throws MalformedURLException {
        setUp();
    }

    @AfterEach
    public void initAfter() {
        driver.close();
        driver.quit();
    }

    public void WaitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void ClickElement(By locator) {
        WaitElement(locator);
        driver.findElement(locator).click();
    }

    public void SendToElement(By locator, String string) {
        WaitElement(locator);
        driver.findElement(locator).sendKeys(string);
    }

    public String GetTextInElement(By locator) {
        WaitElement(locator);
        return driver.findElement(locator).getText();
    }

    @Step("Проверка эквивалентности строки {string1} к строке {string2}")
    public static void checkEqualString(String string1, String string2) {
        Assert.isTrue(string1.equals(string2), "Строки не эквивалентны");
        assertEquals(string1, string2);
    }


}