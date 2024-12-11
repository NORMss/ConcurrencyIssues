package ru.normno.problemPassMeSomeWater

import kotlin.concurrent.thread


fun problem(): WaterBottle? {
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
        synchronized(WaterBottle.Borjomi) {
            Thread.sleep(1_000)
            synchronized(WaterBottle.Karachinskaya) {
                bottle = WaterBottle.Borjomi
            }
        }
    }

    firstWorker.join()
    secondWorker.join()

    return bottle
}
