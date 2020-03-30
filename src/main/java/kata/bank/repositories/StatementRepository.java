package kata.bank.repositories;


import kata.bank.domains.Statement;
import kata.bank.domains.StatementLine;


public interface StatementRepository {

    StatementLine addAccountStatement(StatementLine statementLine, Long accountId);

    Statement getAccountStatement(Long accountId);
}
