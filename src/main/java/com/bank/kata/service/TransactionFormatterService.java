package com.bank.kata.service;

import com.bank.kata.model.Account;
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
     * Formats the transactions of a given account into a string representation.
     *
     * <p>The output should include details of the account and each transaction, such as:
     * - Account owner's name.
     * - Account currency.
     * - Account creation date.
     * - Date of the transaction.
     * - Type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * - Amount involved in the transaction.
     * - The resulting balance after the transaction.
     * - A message indicating no transactions if the account has no history.
     *
     * @param account the account whose transactions are to be formatted.
     * @return a string containing the formatted representation of the account's transactions.
     * @throws IllegalArgumentException if the account is null.
     */
    String format(Account account);
}

