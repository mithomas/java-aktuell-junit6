package eu.java_aktuell.junit6

import kotlinx.coroutines.*

class SuspendFunctionExample {
    
    suspend fun invokeAddition(a: Int, b: Int): Int {
        delay(100L)
        return a + b
    }
    
    fun calculate(a: Int, b: Int): Int = runBlocking {
        invokeAddition(a, b)
    }
}
