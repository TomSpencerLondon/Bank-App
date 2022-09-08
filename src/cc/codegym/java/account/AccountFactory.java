package cc.codegym.java.account;

import cc.codegym.java.client.Client;

public final class AccountFactory {

    private AccountFactory() {
    }

    public static Account create(Client client, AccountType type) {
        return switch (type) {
            case CHECKING -> new Checking(client);
            case SAVINGS -> new Savings(client);
            case INVESTMENT -> new Investment(client);
        };
    }
}
