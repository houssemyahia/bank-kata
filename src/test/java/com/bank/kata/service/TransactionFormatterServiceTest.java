package com.bank.kata.service;

import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * Test suite for TransactionFormatterServiceImpl.
 *
 * <p>This suite verifies that the formatter generates the correct plain-text
 * representation of a list of transactions, including headers and data alignment.
 */
public class TransactionFormatterServiceTest {

    /**
     * Verifies that the formatter correctly formats a list of transactions into
     * a plain-text table.
     *
     * <p>Scenario:
     * - Given: A list of transactions with deposits and withdrawals.
     * - When: The format method is called.
     * - Then: The returned string matches the expected output.
     */
    @Test
    void shouldFormatTransactionsCorrectly() {
        // Stub the date for each transaction to ensure predictable output
        Transaction transaction1 = spy(new Transaction(TransactionType.DEPOSIT, 100.0, 100.0));
        Transaction transaction2 = spy(new Transaction(TransactionType.WITHDRAWAL, 50.0, 50.0));

        doReturn(LocalDateTime.of(2025, 1, 9, 10, 30)).when(transaction1).getDate();
        doReturn(LocalDateTime.of(2025, 1, 9, 10, 35)).when(transaction2).getDate();

        // Arrange: Prepare the formatter and a list of stubbed transactions
        TransactionFormatterService formatter = new TransactionFormatterServiceImpl();
        List<Transaction> transactions = List.of(transaction1, transaction2);

        // Define the expected output with the specific dates and transaction details
        String expectedOutput =
                "Date                | Type       | Amount   | Balance\n" +
                        "-----------------------------------------------------\n" +
                        "2025-01-09T10:30    | DEPOSIT    | 100.00   | 100.00  \n" +
                        "2025-01-09T10:35    | WITHDRAWAL | 50.00    | 50.00   \n";

        // Act: Call the formatter method
        String formattedOutput = formatter.format(transactions);

        // Assert: Verify that the actual output matches the expected output
        assertEquals(expectedOutput, formattedOutput);
    }

    /**
     * Verifies that the formatter handles an empty list of transactions correctly.
     *
     * <p>Scenario:
     * - Given: An empty list of transactions.
     * - When: The format method is called.
     * - Then: The returned string includes only the headers and no transaction data.
     */
    @Test
    void shouldFormatEmptyTransactionList() {
        // Arrange: Set up the formatter and prepare an empty list of transactions
        TransactionFormatterService formatter = new TransactionFormatterServiceImpl();
        List<Transaction> transactions = List.of();

        // Define the expected output: Only the header row is included
        String expectedOutput =
                "Date                | Type       | Amount   | Balance\n" +
                        "-----------------------------------------------------\n";

        // Act: Call the format method with the empty list
        String formattedOutput = formatter.format(transactions);

        // Assert: Verify that the output matches the expected table format
        assertEquals(expectedOutput, formattedOutput);
    }
}

