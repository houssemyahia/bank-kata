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
}
