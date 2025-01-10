package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    /**
     * Verifies that a deposit transaction is correctly recorded.
     *
     * <p>Scenario:
     * - Given: An account with the updated balance of 100.0 after the deposit transaction.
     * - When: The deposit transaction of 100.0 is recorded.
     * - Then: The transaction history contains one deposit transaction.
     */
    @Test
    void shouldRecordDepositTransaction() {
        // Arrange
        TransactionService transactionService = new TransactionServiceImpl();
        Account account = new Account();
        account.setBalance(100.0);
        double depositAmount = 100.0;

        // Act
        transactionService.recordTransaction(account, TransactionType.DEPOSIT, depositAmount);

        // Assert
        List<Transaction> transactions = account.getTransactions();
        assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
        assertEquals(100.0, transaction.getAmount());
        assertEquals(100.0, transaction.getBalanceAfterTransaction());
        assertNotNull(transaction.getDate());
    }

    /**
     * Verifies that a withdrawal transaction is correctly recorded.
     *
     * <p>Scenario:
     * - Given: An account with the updated balance of 150.0 after the withdrawal transaction.
     * - When: The withdrawal transaction of 50.0 is recorded.
     * - Then: The transaction history contains one withdrawal transaction.
     */
    @Test
    void shouldRecordWithdrawalTransaction() {
        // Arrange
        TransactionService transactionService = new TransactionServiceImpl();
        Account account = new Account();
        account.setBalance(150.0);
        double withdrawalAmount = 50.0;

        // Act
        transactionService.recordTransaction(account, TransactionType.WITHDRAWAL, withdrawalAmount);

        // Assert
        List<Transaction> transactions = account.getTransactions();
        assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        assertEquals(TransactionType.WITHDRAWAL, transaction.getType());
        assertEquals(50.0, transaction.getAmount());
        assertEquals(150.0, transaction.getBalanceAfterTransaction());
        assertNotNull(transaction.getDate());
    }

    /**
     * Verifies that getTransactionHistory retrieves the expected transactions.
     *
     * <p>Scenario:
     * - Given: A mocked TransactionService that returns a predefined list of transactions.
     * - When: getTransactionHistory is called with an account.
     * - Then: The returned transaction history matches the predefined transactions.
     */
    @Test
    void shouldRetrieveTransactionHistoryWithMockedTransactions() {
        // Arrange
        TransactionService transactionServiceMock = mock(TransactionService.class);
        Account account = new Account();

        List<Transaction> mockedTransactions = List.of(
                new Transaction(TransactionType.DEPOSIT, 100.0, 100.0),
                new Transaction(TransactionType.WITHDRAWAL, 50.0, 50.0)
        );

        when(transactionServiceMock.getTransactionHistory(account)).thenReturn(mockedTransactions);

        // Act
        List<Transaction> transactions = transactionServiceMock.getTransactionHistory(account);

        // Assert
        assertEquals(2, transactions.size());

        Transaction firstTransaction = transactions.get(0);
        assertEquals(TransactionType.DEPOSIT, firstTransaction.getType());
        assertEquals(100.0, firstTransaction.getAmount());
        assertEquals(100.0, firstTransaction.getBalanceAfterTransaction());

        Transaction secondTransaction = transactions.get(1);
        assertEquals(TransactionType.WITHDRAWAL, secondTransaction.getType());
        assertEquals(50.0, secondTransaction.getAmount());
        assertEquals(50.0, secondTransaction.getBalanceAfterTransaction());

        // Verify that the mock method was called exactly once
        verify(transactionServiceMock, times(1)).getTransactionHistory(account);
    }

    /**
     * Verifies that an exception is thrown when attempting to record a transaction with invalid parameters.
     *
     * <p>Scenario:
     * - Given: A null account or an invalid transaction type or amount.
     * - When: A transaction is attempted to be recorded.
     * - Then: An IllegalArgumentException is thrown.
     */
    @Test
    void shouldThrowExceptionForInvalidTransactionParameters() {
        // Arrange
        TransactionService transactionService = new TransactionServiceImpl();

        // Act & Assert: Null account
        Exception nullAccountException = assertThrows(IllegalArgumentException.class, () ->
                transactionService.recordTransaction(null, TransactionType.DEPOSIT, 100.0));
        assertEquals("Account cannot be null.", nullAccountException.getMessage());

        // Act & Assert: Invalid transaction type
        Account account = new Account();
        Exception nullTypeException = assertThrows(IllegalArgumentException.class, () ->
                transactionService.recordTransaction(account, null, 100.0));
        assertEquals("Transaction type cannot be null.", nullTypeException.getMessage());
    }


}
