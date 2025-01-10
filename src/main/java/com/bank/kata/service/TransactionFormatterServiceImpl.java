package com.bank.kata.service;

import com.bank.kata.model.Transaction;

import java.util.List;

/**
 * Service for formatting a list of transactions into a human-readable plain text statement.
 *
 * <p>The statement includes details such as the transaction date, type, amount, and balance
 * formatted into a table-like structure. This implementation adheres to the requirements
 * of the kata and avoids using external frameworks.
 */
public class TransactionFormatterServiceImpl implements TransactionFormatterService{
    /**
     * Formats a list of transactions into a plain text representation.
     *
     * <p>The formatted output includes a header row followed by transaction details.
     *
     * @param transactions the list of transactions to format.
     * @return a string containing the formatted statement.
     */
    @Override
    public String format(List<Transaction> transactions) {
        StringBuilder builder = new StringBuilder();
        builder.append("Date                | Type       | Amount   | Balance\n");
        builder.append("-----------------------------------------------------\n");

        for (Transaction transaction : transactions) {
            builder.append(String.format("%-19s | %-10s | %-8.2f | %-8.2f\n",
                    transaction.getDate(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getBalanceAfterTransaction()));
        }

        return builder.toString();
    }
}
