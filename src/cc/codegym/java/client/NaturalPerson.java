package cc.codegym.java.client;

public class NaturalPerson extends Client {


    public NaturalPerson(String name, String legalDocument) {
        super(name, legalDocument);
    }

    @Override
    public String getLegalDocument() {
        return super.legalDocument;
    }

    @Override
    public String toString() {
        return "NaturalPerson{" +
            "name='" + name + '\'' +
            ", legalDocument='" + legalDocument + '\'' +
            "}";
    }
}
