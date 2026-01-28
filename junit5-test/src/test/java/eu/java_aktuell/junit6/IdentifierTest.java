package eu.java_aktuell.junit6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentifierTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "xyz"})
    void testUppercaseConversion(Identifier id) {
        assertEquals(id.getValue(), id.getValue().toUpperCase());
    }
}
