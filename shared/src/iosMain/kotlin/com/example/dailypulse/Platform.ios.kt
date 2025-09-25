package com.example.dailypulse

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual  class Platform {
    actual val osVersion: String
        get() = UIDevice.currentDevice().systemVersion
    actual val deviceName: String
        get() = UIDevice.currentDevice().name
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog(
            "($osVersion $deviceName $density)"

        )
    }
}
