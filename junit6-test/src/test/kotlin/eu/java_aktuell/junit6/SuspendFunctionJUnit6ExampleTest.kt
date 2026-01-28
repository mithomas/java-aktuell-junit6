package eu.java_aktuell.junit6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SuspendFunctionExampleTest {
    
    @Test
    suspend fun testInvokeAddition() {
        val example = SuspendFunctionExample()
        val result = example.invokeAddition(10, 20)
        assertEquals(30, result)
    }
}
