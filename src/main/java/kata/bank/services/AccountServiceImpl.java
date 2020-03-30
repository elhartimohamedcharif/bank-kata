package kata.bank.services;


import kata.bank.domains.Account;
import kata.bank.exceptions.AccountNotFoundException;
import kata.bank.repositories.AccountRepository;
import kata.bank.repositories.AccountRepositoryImpl;
import kata.bank.repositories.StatementRepositoryImpl;
import kata.bank.repositories.TransactionRepositoryImpl;


public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl() {
        accountRepository = new AccountRepositoryImpl();
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

    }

    @Override
    public void withdraw(Long accountId, double amount) {

    }

    @Override
    public void printAccountStatement(Long accountId) {


    }
}
