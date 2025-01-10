package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;

import java.util.List;

/**
 /**
 * Formats the transactions of an account into a plain text representation.
 *
 * <p>The formatted output includes account metadata such as the account owner's name,
 * currency, and creation date, followed by a header row and detailed transaction information.
 * This implementation adheres to the requirements of the kata and avoids using external frameworks.
 */
public class TransactionFormatterServiceImpl implements TransactionFormatterService{
    /**
     * Formats the transactions of a given account into a plain text representation.
     *
     * <p>Validations:
     * <ul>
     *     <li>If the account is null, an exception is thrown.</li>
     *     <li>If the account has no transactions, a message indicating no transactions is included.</li>
     * </ul>
     *
     * @param account the account whose transactions are to be formatted.
     * @return a string containing the formatted statement.
     * @throws IllegalArgumentException if the account is null.
     */
    @Override
    public String format(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("The account cannot be null.");
        }

        List<Transaction> transactions = account.getTransactions();
        StringBuilder builder = new StringBuilder();

        // Add account metadata
        builder.append("Account Owner: ").append(account.getOwnerName()).append("\n");
        builder.append("Currency: ").append(account.getCurrency()).append("\n");
        builder.append("Created At: ").append(account.getCreatedAt()).append("\n\n");

        // Add header
        builder.append("Date                | Type       | Amount   | Balance\n");
        builder.append("-----------------------------------------------------\n");

        // Add transaction details or a message if no transactions exist
        if (transactions.isEmpty()) {
            builder.append("No transactions available for this account.\n");
        } else {
            for (Transaction transaction : transactions) {
                builder.append(String.format("%-19s | %-10s | %-8.2f | %-8.2f\n",
                        transaction.getDate(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalanceAfterTransaction()));
            }
        }

        return builder.toString();
    }
}
