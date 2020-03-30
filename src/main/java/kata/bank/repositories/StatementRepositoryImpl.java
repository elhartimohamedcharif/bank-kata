package kata.bank.repositories;


import kata.bank.domains.Account;
import kata.bank.domains.Statement;
import kata.bank.domains.StatementLine;
import kata.bank.exceptions.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;


public class StatementRepositoryImpl implements StatementRepository {

    private static final Map<Long, Statement> statements = new HashMap<>();
    private AccountRepository accountRepository;

    public StatementRepositoryImpl() {
        this.accountRepository = new AccountRepositoryImpl();
    }


    @Override
    public StatementLine addAccountStatement(StatementLine statementLine, Long accountId) {
        Account account = accountRepository.getById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        Statement statement = statements.get(accountId);
        if (statement == null) statement = new Statement();
        statement.getStatementLines().add(statementLine);
        statement.setAccount(account);
        statements.put(accountId, statement);
        return statementLine;
    }

    @Override
    public Statement getAccountStatement(Long accountId) {
        return statements.get(accountId);
    }
}
