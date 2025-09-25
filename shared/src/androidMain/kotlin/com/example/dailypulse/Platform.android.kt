package com.example.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import java.lang.Math.round

actual class Platform {
    actual val osVersion: String
        get() = Build.VERSION.BASE_OS
    actual val deviceName: String
        get() = Build.DEVICE
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {

        Log.d("Daily Pulse", "$osVersion $deviceName $density")
    }


}

