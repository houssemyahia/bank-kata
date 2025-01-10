package com.bank.kata.model;

/**
 * Enum representing the types of transactions that can occur on an account.
 *
 * <p>Each transaction type corresponds to a specific operation that can be
 * performed on an account. For example:
 * - DEPOSIT: Represents money being added to the account.
 * - WITHDRAWAL: Represents money being deducted from the account.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public enum TransactionType {

    /**
     * Represents a deposit transaction.
     */
    DEPOSIT,

    /**
     * Represents a withdrawal transaction.*/
    WITHDRAWAL
}
