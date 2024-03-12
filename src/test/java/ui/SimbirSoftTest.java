package ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pageobject.OpenXyzBank;

import java.io.IOException;
import java.time.LocalDate;

import static ui.TestsProperties.XYZ_BANK_URL;
import static ui.pageobject.BasePage.checkEqualString;

public class SimbirSoftTest extends BaseTest {
    Fibonacci fibonacci;
    OpenXyzBank openXyzBank;
    AllureMethods allureMethods;

    @Owner(value = "Ruslan Bikineev")
    @DisplayName("Check deposit and withdrawal by user 'Harry Potter'")
    @Test
    public void testDepositAndWithdrawal() throws IOException {
        allureMethods = new AllureMethods();
        fibonacci = new Fibonacci(LocalDate.now().getDayOfMonth() + 1);
        openXyzBank = new OpenXyzBank(driver);
        driver.get(XYZ_BANK_URL);
        openXyzBank.clickElement(openXyzBank.customerLoginButton);
        openXyzBank.clickElement(openXyzBank.selectHarryPotterButton);
        openXyzBank.clickElement(openXyzBank.loginButton);
        openXyzBank.clickElement(openXyzBank.depositButton);
        openXyzBank.sendToElement(openXyzBank.amountToDeposited, String.valueOf(fibonacci.getFibonacci()));
        openXyzBank.clickElement(openXyzBank.toBeDepositButton);
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.message), "Deposit Successful");
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.balance), String.valueOf(fibonacci.getFibonacci()));
        openXyzBank.clickElement(openXyzBank.withdrawlButton);
        openXyzBank.sendToElement(openXyzBank.amountToWithdrawn, String.valueOf(fibonacci.getFibonacci()));
        openXyzBank.clickElement(openXyzBank.toBeWithdrawlButton);
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.message), "Transaction successful");
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.balance), "0");
        openXyzBank.clickElement(openXyzBank.transactionsButton);
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.anchor0Amount), String.valueOf(fibonacci.getFibonacci()));
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.anchor0TransactionType), "Credit");
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.anchor1Amount), String.valueOf(fibonacci.getFibonacci()));
        checkEqualString(openXyzBank.getTextInElement(openXyzBank.anchor1TransactionType), "Debit");
        allureMethods.createCsvFile(openXyzBank.getTextInElement(openXyzBank.anchor0Date), openXyzBank.getTextInElement(openXyzBank.anchor0Amount), openXyzBank.getTextInElement(openXyzBank.anchor0TransactionType), openXyzBank.getTextInElement(openXyzBank.anchor1Date), openXyzBank.getTextInElement(openXyzBank.anchor1Amount), openXyzBank.getTextInElement(openXyzBank.anchor1TransactionType));
    }
}
