package ru.normno.prblemDragRacing

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun solutionWithAtomic(): Int {
    val counter = AtomicInteger(0)

    val firstWorker = thread {
        repeat(1_000_000) {
            counter.incrementAndGet()
        }
    }

    val secondWorker = thread {
        repeat(1_000_000) {
            counter.incrementAndGet()
        }
    }

    firstWorker.join()
    secondWorker.join()

    return counter.get()
}
