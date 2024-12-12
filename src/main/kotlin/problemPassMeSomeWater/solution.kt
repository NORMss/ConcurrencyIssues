package ru.normno.problemPassMeSomeWater

import kotlin.concurrent.thread


fun solution(): WaterBottle? {
    var bottle: WaterBottle? = null

    val firstWorker = thread {
        synchronized(WaterBottle.Karachinskaya) {
            Thread.sleep(1_000)
            synchronized(WaterBottle.Borjomi) {
                bottle = WaterBottle.Karachinskaya
            }
        }
    }

    val secondWorker = thread {
        synchronized(WaterBottle.Karachinskaya) {
            Thread.sleep(1_000)
            synchronized(WaterBottle.Borjomi) {
                bottle = WaterBottle.Borjomi
            }
        }
    }

    firstWorker.join()
    secondWorker.join()

    return bottle
}
