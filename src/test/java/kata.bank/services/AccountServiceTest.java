package kata.bank.services;


import kata.bank.domains.Account;
import kata.bank.repositories.TransactionRepository;
import kata.bank.repositories.TransactionRepositoryImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceTest {

    private AccountService accountService;
    private TransactionRepository transactionRepository;
    private Long accountId = 1L;



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

}
