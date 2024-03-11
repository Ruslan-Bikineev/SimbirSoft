package ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.BaseTest;

public class OpenXyzBank extends BaseTest {
    public static final String XYZ_BANK_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    public By customerLoginButton = By.cssSelector("[ng-click='customer()']");
    public By selectHarryPotterButton = By.cssSelector("option[value='2']");
    public By loginButton = By.cssSelector("button.btn-default");
    public By depositButton = By.cssSelector("[ng-click='deposit()']");
    public By amountToDeposited = By.xpath("//label[text()='Amount to be Deposited :']/following-sibling::input");
    public By toBeDepositButton = By.cssSelector("button[type='submit']");
    public By withdrawlButton = By.cssSelector("[ng-click='withdrawl()']");
    public By amountToWithdrawn = By.xpath("//label[text()='Amount to be Withdrawn :']/following-sibling::input");
    public By toBeWithdrawlButton = By.cssSelector("button[type='submit']");
    public By balance = By.xpath("(//div[contains(., 'Balance')]/strong[@class='ng-binding'])[2]");
    public By transactionsButton = By.cssSelector("button[ng-class='btnClass1']");
    public By anchor0Date = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][1]");
    public By anchor0Amount = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][2]");
    public By anchor0TransactionType = By.xpath("//tr[@id='anchor0']//td[@class='ng-binding'][3]");
    public By anchor1Date = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][1]");
    public By anchor1Amount = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][2]");
    public By anchor1TransactionType = By.xpath("//tr[@id='anchor1']//td[@class='ng-binding'][3]");
    public OpenXyzBank(RemoteWebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
