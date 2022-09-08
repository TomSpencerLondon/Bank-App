package cc.codegym.java.account;

public class NegativeValueNotAllowed extends RuntimeException {

    public NegativeValueNotAllowed() {
        super("Operation not allowed for negative values");
    }
}
