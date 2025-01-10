package com.bank.kata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
     * Unique identifier for the account.
     */
    private final String accountId;

    /**
     * Name of the account holder.
     */
    private final String ownerName;

    /**
     * Currency of the account (e.g., USD, EUR).
     */
    private final String currency;

    /**
     * Date when the account was created.
     */
    private final LocalDateTime createdAt;

    /**
     * Represents the current balance of the account.
     */
    private double balance;
    /**
     * A list of transactions associated with the account.
     */
    private List<Transaction> transactions;

    /**
     * Initializes a new account
     *
     * @param ownerName the name of the account holder.
     * @param currency  the currency for the account (e.g., "USD").
     */
    public Account(String ownerName, String currency) {
        this.accountId = UUID.randomUUID().toString();
        this.ownerName = ownerName;
        this.currency = currency;
        this.createdAt = LocalDateTime.now();
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Returns the unique identifier of the account.
     *
     * @return the unique account identifier as a {@code String}.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Returns the name of the account holder.
     *
     * @return the name of the account owner as a {@code String}.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Returns the currency of the account.
     *
     * @return the currency of the account as a {@code String}.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Returns the date and time when the account was created.
     *
     * @return the creation timestamp of the account as a {@code LocalDateTime}.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
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
