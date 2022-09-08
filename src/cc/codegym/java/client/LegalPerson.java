package cc.codegym.java.client;

public class LegalPerson extends Client {

    public static final double EXTRA_FEE = 0.005;//0.5%

    public LegalPerson(String name, String legalDocument) {
        super(name, legalDocument);
    }

    @Override
    public String getLegalDocument() {
        return super.legalDocument;
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
            "name='" + name + '\'' +
            ", legalDocument='" + legalDocument + '\'' +
            "}";
    }
}
