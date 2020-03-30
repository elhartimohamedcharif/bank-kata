package kata.bank;

import kata.bank.domains.Account;
import kata.bank.services.AccountService;
import kata.bank.services.AccountServiceImpl;

public class MainApp {
    public static void main(String[] args) {
        Long accountId = 1L;
        AccountService accountService = new AccountServiceImpl();
        accountService.createAccount(accountId);
        Account account = accountService.findAccountById(accountId);

        accountService.deposit(account.getId(), 1500);
        accountService.deposit(account.getId(), 100);
        accountService.withdraw(account.getId(), 1500);

        System.out.println(account.getBalance());

        System.out.println("----------------------Acount statement--------------------------------");


        accountService.printAccountStatement(account.getId());


    }
}
