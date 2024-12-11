package ru.normno.problemPassMeSomeWater

import kotlin.concurrent.thread


fun solution(): WaterBottle? {
    var bottle: WaterBottle? = null

    val lock1 = WaterBottle.Karachinskaya
    val lock2 = WaterBottle.Borjomi

    val firstWorker = thread {
        val (firstLock, secondLock) = if (System.identityHashCode(lock1) < System.identityHashCode(lock2)) {
            lock1 to lock2
        } else {
            lock2 to lock1
        }

        synchronized(firstLock) {
            Thread.sleep(1_000)
            synchronized(secondLock) {
                bottle = WaterBottle.Karachinskaya
            }
        }
    }

    val secondWorker = thread {
        val (firstLock, secondLock) = if (System.identityHashCode(lock1) < System.identityHashCode(lock2)) {
            lock1 to lock2
        } else {
            lock2 to lock1
        }

        synchronized(firstLock) {
            Thread.sleep(1_000)
            synchronized(secondLock) {
                bottle = WaterBottle.Borjomi
            }
        }
    }

    firstWorker.join()
    secondWorker.join()

    return bottle
}
