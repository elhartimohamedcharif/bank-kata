package kata.bank.repositories;


import kata.bank.domains.Transaction;

import java.util.List;

public interface TransactionRepository {

    Transaction saveTransaction(Transaction transaction, Long accountId);

    List<Transaction> getAllAccountTransactions(Long accountId);


}
