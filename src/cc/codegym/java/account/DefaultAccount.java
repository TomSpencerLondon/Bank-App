package cc.codegym.java.account;

import cc.codegym.java.client.Client;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class DefaultAccount implements Account {

    protected final Client client;
    protected BigDecimal balance;

    protected DefaultAccount(Client client) {
        this.client = client;
        this.balance = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueNotAllowed();
        }
        if (this.balance.compareTo(value) < 0) {
            throw new InsufficientBalanceException();
        }
        this.balance = this.balance.subtract(value);
        return this.balance;
    }

    @Override
    public BigDecimal deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueNotAllowed();
        }
        this.balance = this.balance.add(value);
        return this.balance;
    }

    @Override
    public BigDecimal transfer(BigDecimal value, Account receiver) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueNotAllowed();
        }
        if (this.balance.compareTo(value) < 0) {
            throw new InsufficientBalanceException();
        }
        this.balance = this.balance.subtract(value);
        receiver.deposit(value);
        return this.balance;
    }

    @Override
    public String checkBalance() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(this.balance);
    }


}
