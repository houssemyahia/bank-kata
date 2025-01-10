package com.bank.kata.service;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;
import com.bank.kata.model.TransactionType;

import java.util.List;

/**
 * Provides operations for managing transactions on bank accounts.
 *
 * <p>This service is responsible for managing the business logic related to
 * transactions and ensuring their consistency.
 *
 * <p>Classes implementing this interface:
 * - {@link TransactionServiceImpl}: Default implementation of the TransactionService interface.
 *
 * @author [Houssem Eddine Yahia]
 * @version 1.0
 */
public interface TransactionService {

    /**
     * Records a new transaction for the specified account.
     *
     * @param account the account for which the transaction is being recorded.
     * @param type the type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * @param amount the amount involved in the transaction.
     * @return the updated account with the new transaction recorded.
     */
    Account recordTransaction(Account account, TransactionType type, double amount);

    /**
     * Retrieves the transaction history of the specified account.
     *
     * @param account the account whose transaction history is being retrieved.
     * @return a list of {@link Transaction} objects representing the account's transaction history.
     */
    List<Transaction> getTransactionHistory(Account account);
}

