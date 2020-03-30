package kata.bank.services;


import kata.bank.domains.Account;
import kata.bank.domains.StatementLine;
import kata.bank.domains.Transaction;
import kata.bank.enums.TransactionType;
import kata.bank.exceptions.AccountNotFoundException;
import kata.bank.exceptions.NegativeAmountException;
import kata.bank.repositories.*;

import java.time.LocalDateTime;


public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private StatementRepository statementRepository;

    public AccountServiceImpl() {
        accountRepository = new AccountRepositoryImpl();
        transactionRepository = new TransactionRepositoryImpl();
        statementRepository = new StatementRepositoryImpl();
    }

    @Override
    public Long createAccount(Long id) {
        Account account = new Account();
        account.setId(id);
        accountRepository.createAccount(account);
        return id;
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.getById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public void deposit(Long accountId, double amount) {
        if (amount < 0) throw new NegativeAmountException();
        Account account = accountRepository.getById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        double currentBalance = account.getBalance() + amount;
        account.setBalance(currentBalance);
        Transaction transaction = Transaction
                .builder().transactionTime(LocalDateTime.now())
                .amount(amount)
                .type(TransactionType.DEPOSIT)
                .build();

        StatementLine statementLine = StatementLine.builder()
                .currentBalance(currentBalance)
                .transaction(transaction)
                .build();

        statementRepository.addAccountStatement(statementLine, accountId);
        transactionRepository.saveTransaction(transaction, accountId);
        account.setBalance(currentBalance);
        accountRepository.updateAccount(account);
    }

    @Override
    public void withdraw(Long accountId, double amount) {

    }

    @Override
    public void printAccountStatement(Long accountId) {


    }
}
