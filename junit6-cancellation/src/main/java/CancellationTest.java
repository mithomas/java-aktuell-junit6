import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CancellationTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Setting up test class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tearing down test class");
    }

    @Test
    void testFails() {
        fail("Trigger cancellation.");
    }

    @Test
    void testWouldSucceed() {
        assertTrue(true);
    }
}
