package eu.java_aktuell.junit6

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SuspendFunctionExampleTest {
    
    @Test
    fun testInvokeAddition() = runTest {
        val example = SuspendFunctionExample()
        val result = example.invokeAddition(10, 20)
        assertEquals(30, result)
    }
}
