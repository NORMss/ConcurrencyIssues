package problemPassMeSomeWater

import org.junit.jupiter.api.Test
import ru.normno.problemPassMeSomeWater.WaterBottle
import ru.normno.problemPassMeSomeWater.solution

class ProblemPassMeSomeWaterTest {
    @Test
    fun solutionPassMeSomeWaterTest() {
        val result = solution()
        kotlin.test.assertEquals(result, WaterBottle.Borjomi)
    }
}