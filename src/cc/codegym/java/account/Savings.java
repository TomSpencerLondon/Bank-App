package cc.codegym.java.account;

import cc.codegym.java.client.Client;
import cc.codegym.java.client.LegalPerson;

public class Savings extends DefaultAccount {

    protected Savings(Client client) {
        super(client);
        if (client instanceof LegalPerson) {
            throw new IllegalArgumentException("Not possible for Legal Person to open Savings Account");
        }
    }

    @Override
    public String toString() {
        return "Savings{" +
            "client=" + client +
            ", balance=" + this.checkBalance() +
            "}";
    }
}
