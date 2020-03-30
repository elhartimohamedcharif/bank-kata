package kata.bank.services;


import kata.bank.domains.Account;

public interface AccountService {
    Long createAccount(Long id);

    Account findAccountById(Long id);

    void deposit(Long accountId, double amount);

    void withdraw(Long accountId, double amount);

    void printAccountStatement(Long accountId);

}
