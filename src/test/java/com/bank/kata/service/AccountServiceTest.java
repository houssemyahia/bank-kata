package com.bank.kata.service;

import com.bank.kata.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test suite for the AccountService interface and its implementation.
 *
 * <p>This class verifies the correctness of account operations such as deposit,
 * ensuring that balances are updated accurately. It follows the Arrange-Act-Assert
 * (AAA) pattern for structuring test cases.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class AccountServiceTest {

    /**
     * Validates that a deposit correctly updates the account balance.
     *
     * <p>Scenario:
     * - Given: An empty account.
     * - When: A deposit of 100.0 is made.
     * - Then: The account balance is 100.0.
     */
    @Test
    void shouldIncreaseBalanceWhenDepositIsMade() {
        // Arrange
        AccountService accountService = new AccountServiceImpl();
        Account account = new Account();

        // Act
        accountService.deposit(account, 100.0);

        // Assert
        assertEquals(100.0, account.getBalance());
    }

    /**
     * Tests the behavior of the deposit method when a negative amount is provided.
     *
     * <p>Scenario:
     * - Given: An instance of AccountService and an empty Account.
     * - When: A negative deposit (-100.0) is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Deposit amount must be positive."
     */
    @Test
    void shouldThrowExceptionWhenDepositIsNegative() {
        // Given: An instance of AccountService and an empty Account
        AccountService accountService = new AccountServiceImpl();
        Account account = new Account();

        // When: A negative deposit (-100.0) is attempted
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.deposit(account, -100.0);
        });

        // Then: An IllegalArgumentException is thrown with the expected message
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }


    /**
     * Tests the behavior of the deposit method when a zero amount is provided.
     *
     * <p>
     * - Given: An instance of AccountService and an empty Account.
     * - When: A zero deposit (0.0) is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Deposit amount must be positive."
     */
    @Test
    void shouldThrowExceptionWhenDepositIsZero() {
        // Given: An instance of AccountService and an empty Account
        AccountService accountService = new AccountServiceImpl();
        Account account = new Account();

        // When: A zero deposit (0.0) is attempted
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.deposit(account, 0.0);
        });

        // Then: An IllegalArgumentException is thrown with the expected message
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }
}
