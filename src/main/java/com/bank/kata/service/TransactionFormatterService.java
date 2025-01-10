package com.bank.kata.service;

import com.bank.kata.model.Transaction;

import java.util.List;

/**
 * Interface for formatting a list of transactions into a human-readable format.
 *
 * <p>The implementing class is responsible for generating a string representation
 * of a list of transactions.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public interface TransactionFormatterService {
    /**
     * Formats a list of transactions into a string representation.
     *
     * <p>The output should include details of each transaction, such as:
     * - Date of the transaction.
     * - Type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * - Amount involved in the transaction.
     * - The resulting balance after the transaction.
     *
     * @param transactions the list of transactions to be formatted.
     * @return a string containing the formatted representation of the transactions.
     * @throws IllegalArgumentException if the list of transactions is null.
     */
    String format(List<Transaction> transactions);
}

