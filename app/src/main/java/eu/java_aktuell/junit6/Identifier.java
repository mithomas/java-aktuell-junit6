package eu.java_aktuell.junit6;

public class Identifier {
    private final String value;

    private Identifier(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    public static Identifier of(CharSequence input) {
        return new Identifier(input.toString().toUpperCase());
    }
}
