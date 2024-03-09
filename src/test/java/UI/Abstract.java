package UI;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDate;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract public class Abstract {

    public static WebDriverWait wait;
    public static EventFiringWebDriver driver;
    public static ChromeOptions chromeOptions;
    public static int fibonacciNumber = Fibonacci(LocalDate.now().getDayOfMonth() + 1);
//    public String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.register(new Custom());
    }

    @BeforeEach
    public void init() {
        setUp();
    }
//    @AfterEach
//    public void initAfter() {
//        driver.close();
//        driver.quit();
//    }

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

    public void CreateCSVFile(String Date_0, String Amount_0, String Transaction_0, String Date_1, String Amount_1, String Transaction_1) {
        String currentDirectory = System.getProperty("user.dir") + "/src/test/resources/report.csv";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Date_0).append(";").append(Amount_0).append(";").append(Transaction_0).append("\n");
        stringBuilder.append(Date_1).append(";").append(Amount_1).append(";").append(Transaction_1).append("\n");
        try (FileWriter writer = new FileWriter(currentDirectory)) {
            writer.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int Fibonacci(int num) {
        if (num <= 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        } else {
            return Fibonacci(num - 1) + Fibonacci(num - 2);
        }
    }
}
