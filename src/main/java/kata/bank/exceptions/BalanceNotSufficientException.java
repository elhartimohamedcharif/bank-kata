package kata.bank.exceptions;

public class BalanceNotSufficientException extends RuntimeException {
    public BalanceNotSufficientException() {
        super("the balance is not sufficient");
    }
}
