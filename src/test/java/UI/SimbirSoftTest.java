package UI;

import io.qameta.allure.Owner;
import UI.PageObject.openXYZBank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static UI.PageObject.openXYZBank.fibonacciNumber;

public class SimbirSoftTest extends Abstract {
    openXYZBank openXYZBank;

    @Owner(value = "Ruslan Bikineev")
    @DisplayName("Проверка пополнение и списания счета")
    @Test
    public void Test1() throws InterruptedException, IOException {
        openXYZBank = new openXYZBank(driver);
        driver.get(openXYZBank.XYZBank);
        openXYZBank.ClickElement(openXYZBank.CustomerLoginButton);
        openXYZBank.ClickElement(openXYZBank.SelectHarryPotterButton);
        openXYZBank.ClickElement(openXYZBank.LoginButton);
        openXYZBank.ClickElement(openXYZBank.DepositButton);
        openXYZBank.SendToElement(openXYZBank.AmountToDeposited,String.valueOf(fibonacciNumber));
        openXYZBank.ClickElement(openXYZBank.ToBeDepositButton);
        openXYZBank.ClickElement(openXYZBank.WithdrawlButton);
        openXYZBank.SendToElement(openXYZBank.AmountToWithdrawn,String.valueOf(fibonacciNumber));
        openXYZBank.ClickElement(openXYZBank.ToBeWithdrawlButton);
//        Thread.sleep(10000);
        checkEqualString(openXYZBank.GetTextInElement(openXYZBank.Balance), "0");
        openXYZBank.ClickElement(openXYZBank.TransactionsButton);
        checkEqualString(openXYZBank.GetTextInElement(openXYZBank.Anchor0TransactionType), "Credit");
        checkEqualString(openXYZBank.GetTextInElement(openXYZBank.Anchor1TransactionType), "Debit");
        openXYZBank.CreateCSVFile();
    }
}