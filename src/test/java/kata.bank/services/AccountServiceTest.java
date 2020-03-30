package kata.bank.services;


import kata.bank.domains.Account;
import kata.bank.domains.Transaction;
import kata.bank.enums.TransactionType;
import kata.bank.repositories.TransactionRepository;
import kata.bank.repositories.TransactionRepositoryImpl;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceTest {

    private AccountService accountService;
    private TransactionRepository transactionRepository;
    private Long accountId = 1L;
    private double depositAmount = 1500;
    private double amountWithdrawn = 1000;





    @BeforeAll
    void setUp() {
        accountService = new AccountServiceImpl();
        transactionRepository = new TransactionRepositoryImpl();
    }

    @DisplayName("Should create Account")
    @Test
    @Order(1)
    void createAcountTest() {
        Long id = accountService.createAccount(accountId);
        assertEquals(accountId, id);

    }

    @DisplayName("Should find Account by id")
    @Test
    @Order(2)
    void findAccountTest() {
        Account account = accountService.findAccountById(accountId);
        assertAll(
                () -> assertEquals(accountId, account.getId()),
                () -> assertEquals(0, account.getBalance())
        );
    }

    @DisplayName("Should make a deposit")
    @Test
    @Order(3)
    void makeDepositTest() {
        accountService.deposit(accountId, depositAmount);
        Account account = accountService.findAccountById(accountId);
        assertEquals(depositAmount, account.getBalance());
    }

    @DisplayName("Should create a deposit transaction")
    @Test
    @Order(4)
    void createDepositTransactionTest() {
        Optional<Transaction> transaction = transactionRepository.getAllAccountTransactions(accountId)
                .stream()
                .filter(t -> t.getType() == TransactionType.DEPOSIT)
                .findAny();

        assertAll(
                transaction::isPresent,
                () -> assertEquals(TransactionType.DEPOSIT, transaction.get().getType()),
                () -> assertEquals(depositAmount, transaction.get().getAmount())
        );
    }

    @DisplayName("Should make a withdraw")
    @Test
    @Order(5)
    void makeWithdrawTest() {
        accountService.withdraw(accountId, amountWithdrawn);
        Account account = accountService.findAccountById(accountId);
        double balanceAfterMakingWithDraw = 500;
        assertEquals(balanceAfterMakingWithDraw, account.getBalance());
    }

    @DisplayName("Should create a deposit transaction")
    @Test
    @Order(6)
    void createWithDrawTransactionTest() {
        Optional<Transaction> transaction = transactionRepository.getAllAccountTransactions(accountId)
                .stream().filter(t -> t.getType() == TransactionType.WITHDRAWAL).findAny();
        assertAll(
                transaction::isPresent,
                () -> assertEquals(TransactionType.WITHDRAWAL, transaction.get().getType()),
                () -> assertEquals(amountWithdrawn, transaction.get().getAmount())
        );
    }

}
