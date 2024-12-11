package ru.normno.problemPassMeSomeWater

sealed interface WaterBottle {
    data object Karachinskaya : WaterBottle
    data object Borjomi : WaterBottle
}