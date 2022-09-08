package cc.codegym.java;

import cc.codegym.java.account.Account;
import cc.codegym.java.account.AccountType;
import cc.codegym.java.client.LegalPerson;
import cc.codegym.java.client.NaturalPerson;
import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) {
        LegalPerson legal = new LegalPerson("Codegym", "123456789");
        NaturalPerson natural = new NaturalPerson("Jesse", "1234");

        Bank bank = new Bank();
        bank.createClient(legal);
        bank.getClients().forEach(System.out::println);

        Account accountNatural = bank.createAccount(natural, AccountType.INVESTMENT);
        Account accountLegal = bank.createAccount(legal, AccountType.CHECKING);
        bank.getAccounts().forEach(System.out::println);

        try {
            bank.createAccount(legal, AccountType.SAVINGS);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

        accountNatural.deposit(BigDecimal.valueOf(100));
        accountLegal.deposit(BigDecimal.valueOf(1000));

        accountLegal.transfer(BigDecimal.valueOf(100), accountNatural);
        bank.getAccounts().forEach(System.out::println);

    }
}
