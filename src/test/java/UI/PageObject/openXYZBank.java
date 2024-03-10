package UI.PageObject;
import UI.Abstract;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class openXYZBank extends Abstract {
    public openXYZBank(RemoteWebDriver driver) {
        Abstract.driver = (RemoteWebDriver) driver;
        PageFactory.initElements(driver, this);
    }

    public static String XYZBank = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public By CustomerLoginButton = By.cssSelector("[ng-click='customer()']");
    public By SelectHarryPotterButton = By.cssSelector("option[value='2']");
    public By LoginButton = By.cssSelector("button.btn-default");
    public By DepositButton = By.cssSelector("[ng-click='deposit()']");
    public By AmountToDeposited = By.xpath("//label[text()='Amount to be Deposited :']/following-sibling::input");
    public By ToBeDepositButton = By.cssSelector("button[type='submit']");
    public By  WithdrawlButton = By.cssSelector("[ng-click='withdrawl()']");
    public By AmountToWithdrawn = By.xpath("//label[text()='Amount to be Withdrawn :']/following-sibling::input");
    public By ToBeWithdrawlButton = By.cssSelector("button[type='submit']");
    public By Balance = By.xpath("(//div[contains(., 'Balance')]/strong[@class='ng-binding'])[2]");
    public By TransactionsButton = By.cssSelector("button[ng-class='btnClass1']");
    public By Anchor0Date = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][1]");
    public By Anchor0Amount = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][2]");
    public By Anchor0TransactionType = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][3]");
    public By Anchor1Date = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][1]");
    public By Anchor1Amount = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][2]");
    public By Anchor1TransactionType = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][3]");
    public static int fibonacciNumber = Fibonacci(LocalDate.now().getDayOfMonth() + 1);

    @Attachment(value = "Вложение", fileExtension = ".csv")
    public static byte[] getBytes() throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/report.csv"));
    }

    public static String convertingDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.ENGLISH);
        try {
            Date dateFormat = formatter.parse(date);
            SimpleDateFormat newFormatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a", Locale.ENGLISH);
            date = newFormatter.format(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public void CreateCSVFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(convertingDate(GetTextInElement(Anchor0Date))).append(";");
        stringBuilder.append(GetTextInElement(Anchor0Amount)).append(";");
        stringBuilder.append(GetTextInElement(Anchor0TransactionType)).append("\n");
        stringBuilder.append(convertingDate(GetTextInElement(Anchor1Date))).append(";");
        stringBuilder.append(GetTextInElement(Anchor1Amount)).append(";");
        stringBuilder.append(GetTextInElement(Anchor1TransactionType)).append("\n");
        try (FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/test/resources/report.csv")) {
            writer.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getBytes();
    }

    public static int Fibonacci(int number) {
        int result;
        if (number <= 1) {
            result = 0;
        } else if (number == 2) {
            result = 1;
        } else {
            result = Fibonacci(number - 1) + Fibonacci(number - 2);
        }
        return result;
    }
}
