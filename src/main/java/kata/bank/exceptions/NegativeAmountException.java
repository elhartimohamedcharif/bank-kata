package kata.bank.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("the amount must not be negative");
    }
}
