package ru.normno.prblemDragRacing

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

fun solutionWithReentrantLock(): Int {
    var counter = 0
    val lock = ReentrantLock()

    val firstWorker = thread {
        repeat(1_000_000) {
            lock.lock()
            try {
                counter++
            } finally {
                lock.unlock()
            }
        }
    }

    val secondWorker = thread {
        repeat(1_000_000) {
            lock.lock()
            try {
                counter++
            } finally {
                lock.unlock()
            }
        }
    }

    firstWorker.join()
    secondWorker.join()

    return counter
}
