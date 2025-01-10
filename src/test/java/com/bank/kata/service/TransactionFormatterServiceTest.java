package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * Test suite for TransactionFormatterServiceImpl.
 *
 * <p>This suite verifies that the formatter generates the correct plain-text
 * representation of an account's transactions, including headers, account details,
 * and data alignment.
 */
public class TransactionFormatterServiceTest {

    /**
     * Verifies that the formatter correctly formats an account's transactions into
     * a plain-text table.
     *
     * <p>Scenario:
     * - Given: An account with a list of transactions (deposits and withdrawals).
     * - When: The format method is called.
     * - Then: The returned string matches the expected output.
     */
    @Test
    void shouldFormatAccountTransactionsCorrectly() {
        // Arrange: Create an account and stub transactions with predictable dates
        Account account = new Account("John Doe", "USD");
        Transaction transaction1 = spy(new Transaction(TransactionType.DEPOSIT, 100.0, 100.0));
        Transaction transaction2 = spy(new Transaction(TransactionType.WITHDRAWAL, 50.0, 50.0));
        doReturn(LocalDateTime.of(2025, 1, 9, 10, 30)).when(transaction1).getDate();
        doReturn(LocalDateTime.of(2025, 1, 9, 10, 35)).when(transaction2).getDate();

        account.getTransactions().add(transaction1);
        account.getTransactions().add(transaction2);

        TransactionFormatterService formatter = new TransactionFormatterServiceImpl();

        // Define the expected output with account details and transactions
        String expectedOutput =
                "Account Owner: John Doe\n" +
                        "Currency: USD\n" +
                        "Created At: " + account.getCreatedAt() + "\n\n" +
                        "Date                | Type       | Amount   | Balance\n" +
                        "-----------------------------------------------------\n" +
                        "2025-01-09T10:30    | DEPOSIT    | 100.00   | 100.00  \n" +
                        "2025-01-09T10:35    | WITHDRAWAL | 50.00    | 50.00   \n";

        // Act: Call the formatter method
        String formattedOutput = formatter.format(account);

        // Assert: Verify that the actual output matches the expected output
        assertEquals(expectedOutput, formattedOutput);
    }

    /**
     * Verifies that the formatter handles an account with no transactions correctly.
     *
     * <p>Scenario:
     * - Given: An account with no transactions.
     * - When: The format method is called.
     * - Then: The returned string includes account details and a message indicating
     *         no transactions are available.
     */
    @Test
    void shouldFormatAccountWithNoTransactions() {
        // Arrange: Create an account with no transactions
        Account account = new Account("John Doe", "USD");
        TransactionFormatterService formatter = new TransactionFormatterServiceImpl();

        // Define the expected output: Account details with no transactions message
        String expectedOutput =
                "Account Owner: John Doe\n" +
                        "Currency: USD\n" +
                        "Created At: " + account.getCreatedAt() + "\n\n" +
                        "Date                | Type       | Amount   | Balance\n" +
                        "-----------------------------------------------------\n" +
                        "No transactions available for this account.\n";

        // Act: Call the formatter method
        String formattedOutput = formatter.format(account);

        // Assert: Verify that the output matches the expected format
        assertEquals(expectedOutput, formattedOutput);
    }
}
