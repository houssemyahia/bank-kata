package com.bank.kata.model;

import java.time.LocalDateTime;

/**
 * Represents a transaction performed on an account.
 *
 * <p>A transaction records details such as the type of operation
 * (e.g., deposit, withdrawal), the amount involved, the resulting
 * balance, and the timestamp of when the transaction occurred.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class Transaction {
    /**
     * The timestamp when the transaction was performed.
     */
    private final LocalDateTime date;

    /**
     * The type of transaction (e.g., DEPOSIT, WITHDRAWAL).
     */
    private final TransactionType type;

    /**
     * The amount involved in the transaction.
     */
    private final double amount;

    /**
     * The account balance immediately after the transaction.
     */
    private final double balanceAfterTransaction;

    /**
     * Creates a new Transaction.
     *
     * @param type the type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * @param amount the amount involved in the transaction.
     * @param balanceAfterTransaction the balance after the transaction is completed.
     */
    public Transaction(TransactionType type, double amount, double balanceAfterTransaction) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    /**
     * Retrieves the timestamp of the transaction.
     *
     * @return the timestamp when the transaction was performed.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Retrieves the type of transaction.
     *
     * @return the type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Retrieves the amount involved in the transaction.
     *
     * @return the amount of the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the balance after the transaction was completed.
     *
     * @return the account balance after the transaction.
     */
    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }
}