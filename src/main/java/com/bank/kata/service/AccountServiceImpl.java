package com.bank.kata.service;

import com.bank.kata.model.Account;

/**
 * Implementation of the AccountService interface.
 *
 * <p>The AccountServiceImpl class provides the business logic for
 * operations such as deposits and withdrawals. It ensures that
 * all operations comply with defined business rules.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class AccountServiceImpl implements AccountService {
    /**
     * Deposits a specified amount into the given account.
     *
     * <p>Business rules:
     * - The deposit amount must be greater than 0.
     * - If the deposit amount is valid, it is added to the account's balance.
     *
     * @param account the account into which the deposit is made.
     * @param amount the amount to deposit.
     * @throws IllegalArgumentException if the deposit amount is zero or negative.
     */
    @Override
    public void deposit(Account account, double amount) {
        // Validate the deposit amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        // Update the account balance
        account.setBalance(account.getBalance() + amount);
    }

    /**
     * Withdraws a specified amount from the given account.
     *
     * <p>Business Rule:
     * - The withdrawal amount is deducted from the account's current balance.
     * - This method assumes that the withdrawal amount is valid and that sufficient funds
     *   are available in the account. Any validations related to negative amounts or
     *   insufficient funds should be handled before calling this method.
     *
     * @param account the account from which the withdrawal is made.
     * @param amount the amount to withdraw.
     */
    @Override
    public void withdraw(Account account, double amount) {
        // Deduct the withdrawal amount from the account balance
        account.setBalance(account.getBalance() - amount);
    }
}
