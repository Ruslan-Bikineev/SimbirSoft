package UI;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract public class Abstract {

    public static WebDriverWait wait;
    public static ChromeDriver driver;
    public static ChromeOptions chromeOptions;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeEach
    public void init() {
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

    @Step("Проверка эквивалентности строки {string1} строке {string2}")
    public static void checkEqualString(String string1, String string2) throws IOException{
        Assert.isTrue(string1.equals(string2), "Строки не эквивалентны");
        assertEquals(string1, string2);
    }


}
