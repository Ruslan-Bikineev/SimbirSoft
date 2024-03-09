package UI.PageObject;
import UI.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class openXYZBank extends Abstract {
    public openXYZBank(WebDriver driver) {
        Abstract.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }

    public String XYZBank = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

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


}
