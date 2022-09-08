package cc.codegym.java.account;

import java.math.BigDecimal;

public interface Account {

    BigDecimal withdraw(BigDecimal value);
    BigDecimal deposit(BigDecimal value);
    BigDecimal transfer(BigDecimal value, Account receiver);
    String checkBalance();

}
