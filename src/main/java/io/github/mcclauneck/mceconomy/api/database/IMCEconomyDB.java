package io.github.mcclauneck.mceconomy.api.database;

import java.util.concurrent.CompletableFuture;

/**
 * Interface for MCEconomy database operations.
 * Optimized for FoliaMC using CompletableFuture for asynchronous, non-blocking execution.
 * Supports multiple account types and dynamic custom currencies via IDs.
 */
public interface IMCEconomyDB {

    /**
     * Asynchronously retrieves the balance for a specific account and currency.
     *
     * @param accountId   The unique identifier of the account (e.g., Player UUID).
     * @param accountType The type of account (e.g., "PLAYER", "CLAN").
     * @param currencyId  The ID of the custom currency.
     * @return A CompletableFuture containing the balance, or 0 if no record exists.
     */
    CompletableFuture<Long> getBalance(String accountId, String accountType, int currencyId);

    /**
     * Asynchronously sets an account's balance.
     *
     * @param accountId   The unique identifier of the account.
     * @param accountType The type of account.
     * @param currencyId  The ID of the custom currency.
     * @param amount      The new balance to set.
     * @return A CompletableFuture evaluating to true if successful, false otherwise.
     */
    CompletableFuture<Boolean> setBalance(String accountId, String accountType, int currencyId, long amount);

    /**
     * Asynchronously increases an account's balance.
     *
     * @param accountId   The unique identifier of the account.
     * @param accountType The type of account.
     * @param currencyId  The ID of the custom currency.
     * @param amount      The amount to add.
     * @return A CompletableFuture evaluating to true if successful.
     */
    CompletableFuture<Boolean> addBalance(String accountId, String accountType, int currencyId, long amount);

    /**
     * Asynchronously decreases an account's balance safely.
     *
     * @param accountId   The unique identifier of the account.
     * @param accountType The type of account.
     * @param currencyId  The ID of the custom currency.
     * @param amount      The amount to subtract.
     * @return A CompletableFuture evaluating to true if successful, false if insufficient funds.
     */
    CompletableFuture<Boolean> subtractBalance(String accountId, String accountType, int currencyId, long amount);

    /**
     * Asynchronously transfers currency from one account to another.
     *
     * @param senderId     The unique identifier of the sender.
     * @param senderType   The account type of the sender.
     * @param receiverId   The unique identifier of the receiver.
     * @param receiverType The account type of the receiver.
     * @param currencyId   The ID of the custom currency.
     * @param amount       The amount to transfer.
     * @return A CompletableFuture evaluating to true if the transfer was successful.
     */
    CompletableFuture<Boolean> transferBalance(String senderId, String senderType, String receiverId, String receiverType, int currencyId, long amount);

    /**
     * Asynchronously ensures that a database record exists for the specified account.
     *
     * @param accountId   The unique identifier of the account.
     * @param accountType The type of account.
     * @param currencyId  The ID of the custom currency.
     * @return A CompletableFuture evaluating to true if the record exists or was created safely.
     */
    CompletableFuture<Boolean> ensureAccountExists(String accountId, String accountType, int currencyId);

    /**
     * Closes the database connection pool safely.
     */
    void close();
}
