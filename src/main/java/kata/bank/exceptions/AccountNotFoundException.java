package kata.bank.exceptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("account with id : " + id + "not found");
    }
}
