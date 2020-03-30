package kata.bank.repositories;


import kata.bank.domains.Transaction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransactionRepositoryImpl implements TransactionRepository {

    private static Map<Long, List<Transaction>> transactions = new HashMap<>();

    @Override
    public Transaction saveTransaction(Transaction transaction, Long accountId) {
        List<Transaction> accountTransactions = transactions.get(accountId);
        if (accountTransactions == null) accountTransactions = new LinkedList<>();

        accountTransactions.add(transaction);
        transactions.put(accountId, accountTransactions);
        return transaction;
    }

    @Override
    public List<Transaction> getAllAccountTransactions(Long accountId) {
        return transactions.get(accountId);
    }


}
