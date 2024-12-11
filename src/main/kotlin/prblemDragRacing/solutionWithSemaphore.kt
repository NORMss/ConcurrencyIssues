package ru.normno.prblemDragRacing

import java.util.concurrent.Semaphore
import kotlin.concurrent.thread

fun solutionWithSemaphore(): Int {
    var counter = 0
    val semaphore = Semaphore(1)

    val firstWorker = thread {
        repeat(1_000_000) {
            semaphore.acquire()
            try {
                counter++
            } finally {
                semaphore.release()
            }
        }
    }

    val secondWorker = thread {
        repeat(1_000_000) {
            semaphore.acquire()
            try {
                counter++
            } finally {
                semaphore.release()
            }
        }
    }

    firstWorker.join()
    secondWorker.join()

    return counter
}