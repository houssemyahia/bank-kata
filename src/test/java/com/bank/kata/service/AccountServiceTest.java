package com.bank.kata.service;

import org.junit.jupiter.api.Test;

/**
 * Test suite for the AccountService interface and its implementation.
 *
 * <p>This class verifies the correctness of account operations such as deposit,
 * ensuring that balances are updated accurately. It follows the Arrange-Act-Assert
 * (AAA) pattern for structuring test cases.
 *
 * @author Houssem Eddine Yahia
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
}
