package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;

import java.util.List;

/**
 * Implementation of the TransactionService interface.
 *
 * <p>This class provides the functionality for managing transactions on
 * accounts, including recording new transactions and retrieving the transaction history.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public class TransactionServiceImpl implements TransactionService {

    /**
     * Records a new transaction for the specified account.
     *
     * @param account the account for which the transaction is being recorded.
     * @param type the type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * @param amount the amount involved in the transaction.
     * @return the updated account with the new transaction recorded.
     */
    @Override
    public Account recordTransaction(Account account, TransactionType type, double amount) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null.");
        }

        // Create a new transaction and add it to the account's transaction list
        Transaction transaction = new Transaction(type, amount, account.getBalance());
        account.getTransactions().add(transaction);

        return account;
    }

    /**
     * Retrieves the transaction history of the specified account.
     *
     * @param account the account whose transaction history is being retrieved.
     * @return a list of {@link Transaction} objects representing the account's transaction history.
     */
    @Override
    public List<Transaction> getTransactionHistory(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        // Return the list of transactions for the given account
        return account.getTransactions();
    }
}

