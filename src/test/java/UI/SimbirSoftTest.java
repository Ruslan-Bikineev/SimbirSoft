package UI;

import UI.PageObject.openXYZBank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimbirSoftTest extends Abstract {
    openXYZBank openXYZBank;

    @Test
    public void Test1()  throws InterruptedException {
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
        assertEquals(Integer.valueOf(openXYZBank.GetTextInElement(openXYZBank.Balance)), 0);
        Thread.sleep(3000);
        openXYZBank.ClickElement(openXYZBank.TransactionsButton);
        assertEquals(openXYZBank.GetTextInElement(openXYZBank.Anchor0TransactionType), "Credit");
        assertEquals(openXYZBank.GetTextInElement(openXYZBank.Anchor1TransactionType), "Debit");
        CreateCSVFile(openXYZBank.GetTextInElement(openXYZBank.Anchor0Date),
                openXYZBank.GetTextInElement(openXYZBank.Anchor0Amount),
                openXYZBank.GetTextInElement(openXYZBank.Anchor0TransactionType),
                openXYZBank.GetTextInElement(openXYZBank.Anchor1Date),
                openXYZBank.GetTextInElement(openXYZBank.Anchor1Amount),
                openXYZBank.GetTextInElement(openXYZBank.Anchor1TransactionType));

    }

    public static void Sum(int a, int b, int sum) {
        Assertions.assertEquals(a+b, sum);
    }

    @Test
    public void FiledTest() {
        Sum(1, 2, 3);
    }
}
