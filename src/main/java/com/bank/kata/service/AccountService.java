package com.bank.kata.service;

import com.bank.kata.model.Account;

/**
 * Defines the operations that can be performed on a bank account.
 *
 * <p>The AccountService interface provides a contract for implementing
 * business logic related to bank accounts, such as deposits and withdrawals.
 * Implementations of this interface should enforce business rules, such as
 * ensuring valid deposit amounts or sufficient funds for withdrawals.
 *
 * <p>Classes implementing this interface:
 * - {@link AccountServiceImpl}: Default implementation of the AccountService interface.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public interface AccountService {
    /**
     * Deposits a specified amount into the given account.
     *
     * <p>Business rules:
     * - The deposit amount must be greater than 0.
     * - If the deposit is valid, it increases the account's balance by the specified amount.
     *
     * @param account the account into which the deposit is made.
     * @param amount the amount to deposit.
     * @throws IllegalArgumentException if the deposit amount is zero or negative.
     */
    void deposit(Account account, double amount);

    void withdraw(Account account, double amount);

}
