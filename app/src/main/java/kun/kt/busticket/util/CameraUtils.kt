package kun.kt.busticket.util

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import java.lang.Exception

fun Context.checkCameraHardware(): Boolean {
    return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
}

fun getCameraInstance(): Camera? = try {
    Camera.open()
} catch (e: Exception) {
    throw e
}
