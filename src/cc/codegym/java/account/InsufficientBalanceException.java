package cc.codegym.java.account;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException() {
        super("Insufficient balance to complete the requested operation");
    }
}
