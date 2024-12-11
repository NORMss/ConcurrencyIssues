package prblemDragRacing

import org.junit.jupiter.api.Test
import ru.normno.prblemDragRacing.problem
import ru.normno.prblemDragRacing.solutionWithAtomic
import ru.normno.prblemDragRacing.solutionWithReentrantLock
import ru.normno.prblemDragRacing.solutionWithSemaphore
import kotlin.test.assertEquals

class ProblemDragRacingTest {
    @Test
    fun problemDragRacingTest() {
        val result = problem()
        assert(result in 1000001..1999999)
    }

    @Test
    fun solutionWithReentrantLockTest() {
        val result = solutionWithReentrantLock()
        assertEquals(result, 2_000_000)
    }

    @Test
    fun solutionWithAtomicTest() {
        val result = solutionWithAtomic()
        assertEquals(result, 2_000_000)
    }

    @Test
    fun solutionWithSemaphoreTest() {
        val result = solutionWithSemaphore()
        assertEquals(result, 2_000_000)
    }
}