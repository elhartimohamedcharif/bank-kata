package kata.bank;

import kata.bank.domains.Account;
import kata.bank.services.AccountService;
import kata.bank.services.AccountServiceImpl;


public class MainApplication {
    public static void main(String[] args) {
        Long accountId = 1L;
        AccountService accountService = new AccountServiceImpl();
        accountService.createAccount(accountId);

        Account account = accountService.findAccountById(accountId);


        accountService.deposit(account.getId(), 1500);
        accountService.deposit(account.getId(), 1500);
        accountService.withdraw(account.getId(), 1500);
        accountService.printAccountStatement(account.getId());
    }
}
