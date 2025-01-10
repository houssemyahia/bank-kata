package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

/**
 * Unit tests for the TransactionService implementation.
 *
 * <p>This class ensures the correctness of transaction management operations,
 * such as recording transactions and retrieving transaction history. The tests
 * use Mockito to isolate dependencies and focus on the behavior of the methods
 * under test.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class TransactionServiceTest {

    /**
     * Verifies that the transaction history correctly records a deposit transaction.
     *
     * <p>Scenario:
     * - Given: An account with no initial transactions.
     * - When: A deposit of 100.0 is made to the account.
     * - Then: The transaction history contains exactly one transaction with:
     */
    @Test
    void shouldReturnHistoryWithOneDepositTransaction() {
        // Arrange: Mock AccountService and create a real TransactionService
        AccountService accountService = mock(AccountService.class);
        TransactionService transactionService = new TransactionServiceImpl();
        Account account = new Account();

        // Mock deposit behavior: directly add a transaction to the account
        doAnswer(invocation -> {
            account.getTransactions().add(new Transaction(TransactionType.DEPOSIT, 100.0, 100.0));
            account.setBalance(100.0);
            return null;
        }).when(accountService).deposit(account, 100.0);

        // Act: Perform deposit and retrieve transaction history
        accountService.deposit(account, 100.0);
        List<Transaction> history = transactionService.getTransactionHistory(account);

        // Assert: Verify transaction history
        assertEquals(1, history.size());
        Transaction transaction = history.get(0);
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
        assertEquals(100.0, transaction.getAmount());
        assertEquals(100.0, transaction.getBalanceAfterTransaction());
        assertNotNull(transaction.getDate());
    }
}
