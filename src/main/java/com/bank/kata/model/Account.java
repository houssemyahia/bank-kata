package com.bank.kata.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with a balance.
 *
 * <p>The Account class is a simple data structure that maintains the
 * current balance of the account. It provides methods to get and update
 * the balance. The initial balance is set to 0.0 when the account is created.
 *
 * <p>This class is used by services like AccountService to perform operations
 * such as deposits and withdrawals.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class Account {
    /**
     * Represents the current balance of the account.
     */
    private double balance;
    /**
     * A list of transactions associated with the account.
     */
    private List<Transaction> transactions;

    /**
     * Initializes a new account with a balance of 0.0.
     */
    public Account() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Gets the current balance of the account.
     *
     * @return the current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the balance of the account.
     *
     * @param balance the new balance to set.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the list of transactions for the account.
     *
     * @return a list of {@link Transaction} objects associated with the account.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
