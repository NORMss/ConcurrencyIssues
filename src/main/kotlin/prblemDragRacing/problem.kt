package ru.normno.prblemDragRacing

import kotlin.concurrent.thread

fun problem(): Int {
    var counter = 0

    val firstWorker = thread {
        repeat(1_000_000) {
            counter++
        }
    }

    val secondWorker = thread {
        repeat(1_000_000) {
            counter++
        }
    }

    firstWorker.join()
    secondWorker.join()

    return counter
}