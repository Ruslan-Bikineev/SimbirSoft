package ui.pageobject;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Check if string {string1} is equal to string {string2}")
    public static void checkEqualString(String string1, String string2) {
        Assert.isTrue(string1.equals(string2), "Strings are not equal");
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementAndRefreshed(By locator) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public void waitForClickabelElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickElement(By locator) {
        waitForElement(locator);
        waitForClickabelElement(locator);
        driver.findElement(locator).click();
    }

    public void sendToElement(By locator, String string) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(string);
    }

    public String getTextInElement(By locator) {
        waitForElementAndRefreshed(locator);
        return driver.findElement(locator).getText();
    }
}
