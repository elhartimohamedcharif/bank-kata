package services;


import kata.bank.repositories.TransactionRepository;
import kata.bank.repositories.TransactionRepositoryImpl;
import kata.bank.services.AccountService;
import kata.bank.services.AccountServiceImpl;
import org.junit.jupiter.api.*;
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

}
