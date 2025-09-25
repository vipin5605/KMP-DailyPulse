package com.example.dailypulse

expect class Platform {
    val osVersion: String
    val deviceName : String
    val density : Int

    fun logSystemInfo()
}

