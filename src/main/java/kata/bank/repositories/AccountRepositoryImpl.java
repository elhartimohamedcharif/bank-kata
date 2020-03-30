package kata.bank.repositories;


import kata.bank.domains.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private static final Map<Long, Account> accounts = new HashMap<>();

    @Override
    public void createAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {
    }

    @Override
    public Optional<Account> getById(Long id) {
        return null;
    }
}
