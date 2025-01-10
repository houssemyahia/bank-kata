package com.bank.kata.service;

import com.bank.kata.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

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
     * Mocked instance of TransactionService used to isolate its behavior
     * during tests.
     */
    private TransactionService transactionServiceMock;

    /**
     * Instance of AccountService under test, initialized with the mocked
     * TransactionService.
     */
    private AccountService accountService;

    /**
     * Initializes the test environment before each test.
     *
     * <p>This method is executed before each test to set up the required dependencies
     * for the test cases. It creates a mocked instance of {@link TransactionService}
     * using Mockito and injects it into the {@link AccountServiceImpl} to isolate
     * the behavior of the account service during testing.
     */
    @BeforeEach
    void setUp() {
        // Mock the TransactionService dependency
        transactionServiceMock = mock(TransactionService.class);

        // Inject the mock into AccountServiceImpl
        accountService = new AccountServiceImpl(transactionServiceMock);
    }

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
        // Arrange: Create an account with an initial balance
        Account account = new Account("Joe","EUR");

        // Act: Withdraw an amount from the account
        accountService.deposit(account, 100.0);

        // Assert: Verify that the balance is updated correctly after the withdrawal
        assertEquals(100.0, account.getBalance());
    }

    /**
     * Tests the behavior of the deposit method when a negative amount is provided.
     *
     * <p>Scenario:
     * - Given: an empty Account.
     * - When: A negative deposit (-100.0) is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Deposit amount must be positive."
     */
    @Test
    void shouldThrowExceptionWhenDepositIsNegative() {
        // Arrange: Create an empty account
        Account account = new Account("Joe","EUR");

        // Act: Attempt a negative deposit (-100.0) and capture the exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.deposit(account, -100.0);
        });

        // Assert: Verify the exception message is as expected
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }


    /**
     * Tests the behavior of the deposit method when a zero amount is provided.
     *
     * <p>Scenario:
     * - Given: an empty Account.
     * - When: A zero deposit (0.0) is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Deposit amount must be positive."
     */
    @Test
    void shouldThrowExceptionWhenDepositIsZero() {
        // Arrange: an empty Account
        Account account = new Account("Joe","EUR");

        // Act: Attempt a zero deposit (0.0) and capture the exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.deposit(account, 0.0);
        });

        // Assert: Verify the exception message
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    /**
     * Tests the behavior of the withdraw method when a valid amount is withdrawn.
     *
     * <p>Scenario:
     * - Given: An account with an initial balance of 200.0.
     * - When: A withdrawal of 50.0 is made.
     * - Then: The account balance should decrease to 150.0.
     */
    @Test
    void shouldDecreaseBalanceWhenWithdrawalIsMade() {
        // Arrange: Create an account with an initial balance
        Account account = new Account("Joe","EUR");
        account.setBalance(200.0); // Directly set the initial balance

        // Act: Withdraw an amount
        accountService.withdraw(account, 50.0);

        // Assert: Verify the balance is updated correctly
        assertEquals(150.0, account.getBalance());
    }

    /**
     * Tests the behavior of the withdraw method when the withdrawal amount
     * exceeds the current account balance.
     *
     * <p>Scenario:
     * - Given: An account with a balance of 100.0.
     * - When: A withdrawal of 200.0 is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Insufficient funds."
     */
    @Test
    void shouldThrowExceptionWhenWithdrawalExceedsBalance() {
        // Arrange: Create an account with a balance of 100.0
        Account account = new Account("Joe","EUR");
        account.setBalance(100.0); // Deposit initial balance

        // Act & Assert: Attempt to withdraw more than the balance and verify the exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdraw(account, 200.0); // Withdrawal exceeds balance
        });

        // Assert: Verify the exception message
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    /**
     * Tests the behavior of the withdraw method when a negative withdrawal amount
     * is provided.
     *
     * <p>Scenario:
     * - Given: An account with a balance (default zero).
     * - When: A withdrawal of -50.0 is attempted.
     * - Then: An IllegalArgumentException is thrown with the message:
     * "Withdrawal amount must be positive."
     */
    @Test
    void shouldThrowExceptionWhenWithdrawalIsNegative() {
        // Arrange: Create an account with default balance
        Account account = new Account("Joe","EUR");

        // Act & Assert: Attempt to withdraw a negative amount and verify the exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdraw(account, -50.0); // Negative withdrawal
        });

        // Assert: Verify the exception message
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }
}
