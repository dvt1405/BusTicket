package kun.kt.busticket.util

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build

fun Activity.hasPermissions(vararg permissions: String): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        for (permission in permissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
    }
    return true
}

fun Activity.checkMultiPermissions(vararg permissions: String) {
    for (permission in permissions) {
        if (!hasPermissions(permission)) {

        }
    }
}