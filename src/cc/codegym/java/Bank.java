package cc.codegym.java;

import cc.codegym.java.account.Account;
import cc.codegym.java.account.AccountFactory;
import cc.codegym.java.account.AccountType;
import cc.codegym.java.client.Client;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {

    private final Set<Client> clients;
    private final List<Account> accounts;

    public Bank() {
        this.clients = new HashSet<>();
        this.accounts = new ArrayList<>();
    }

    public Set<Client> getClients() {
        return Set.copyOf(this.clients);
    }

    public List<Account> getAccounts() {
        return List.copyOf(this.accounts);
    }

    public void createClient(Client client) {
        this.clients.add(client);
    }

    public Account createAccount(Client client, AccountType type) {
        Account account = AccountFactory.create(client, type);
        this.accounts.add(account);
        return account;
    }

}
