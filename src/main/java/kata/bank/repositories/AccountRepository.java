package kata.bank.repositories;

import kata.bank.domains.Account;

import java.util.Optional;

public interface AccountRepository {

    void createAccount(Account account);

    void updateAccount(Account account);

    Optional<Account> getById(Long id);

}
