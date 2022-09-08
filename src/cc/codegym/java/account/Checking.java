package cc.codegym.java.account;

import cc.codegym.java.client.Client;
import cc.codegym.java.client.LegalPerson;
import java.math.BigDecimal;

public class Checking extends DefaultAccount {

    protected Checking(Client client) {
        super(client);
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) {
        BigDecimal actualValue = applyFeeForLegalPerson(value);
        return super.withdraw(actualValue);
    }

    @Override
    public BigDecimal transfer(BigDecimal value, Account receiver) {
        BigDecimal actualValue = applyFeeForLegalPerson(value);
        return super.transfer(actualValue, receiver);
    }

    private BigDecimal applyFeeForLegalPerson(BigDecimal value) {
        BigDecimal actualValue = value;
        if (super.client instanceof LegalPerson) {
            actualValue = actualValueForLegalPerson(value);
        }
        return actualValue;
    }

    private BigDecimal actualValueForLegalPerson(BigDecimal value) {
        return value.add(value.multiply(BigDecimal.valueOf(LegalPerson.EXTRA_FEE)));//$100 + $100*0.5%
    }

    @Override
    public String toString() {
        return "Checking{" +
            "client=" + client +
            ", balance=" + this.checkBalance() +
            "}";
    }
}
