package cc.codegym.java.client;

import java.util.Objects;

public abstract class Client {

    protected final String name;
    protected final String legalDocument;

    protected Client(String name, String legalDocument) {
        this.name = name;
        this.legalDocument = legalDocument;
    }

    public String getName() {
        return name;
    }

    public abstract String getLegalDocument();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return name.equalsIgnoreCase(client.name) && legalDocument.equalsIgnoreCase(client.legalDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, legalDocument);
    }
}
