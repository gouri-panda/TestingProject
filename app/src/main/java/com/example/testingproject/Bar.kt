package com.example.testingproject

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.location.Location
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val arrayList =
        arrayListOf(One(), One(), One(), One(), Two(), Two(), Three(), Three(), Two(), One())
    val filterOneList = arrayList.filterIsInstance<Two>()
    println(filterOneList.size)
}

class One() {}
class Two() {}
class Three() {}

fun View.showSnackBar(message: String, listener: ((View) -> Unit)? = null) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).setAction("Action", listener).show()
}

fun View.showSnackBar(resourceId: Int, listener: ((View) -> Unit)? = null) {
    showSnackBar(resources.getString(resourceId), listener)
}

fun Activity.hideK() {
    currentFocus
}


fun foo(context: Context, viewGroup: ViewGroup, id: Int) {

}

fun String.toDate(format: String): Date? {
    val simpleDateFormat = SimpleDateFormat(format, Locale.US)
    return try {
        simpleDateFormat.parse(this)
    } catch (e: Exception) {
        null
    }
}

fun Date.toString(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.US)
    return simpleDateFormat.format(this)
}

fun String.toLocation(provider: String): Location? {
    val components = this.split(",")
    if (components.size != 2) return null
    val latitude = components[0].toDoubleOrNull() ?: return null
    val longitude = components[1].toDoubleOrNull() ?: return null
    val location = Location(provider)
    location.latitude = latitude
    location.longitude = longitude
    return location
}

val Context.versionName
    get() = try {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        packageInfo.versionName
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
val Context.versionCode
    get() = try {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo.longVersionCode
        } else {
            packageInfo.versionCode.toLong()
        }
    } catch (e: Exception) {
        null
    }
@Suppress("DEPRECATION")
val Context.screenSize: Point
    get() {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val defaultDisplay = windowManager.defaultDisplay
        val point = Point()
        defaultDisplay.getSize(point)
        return point
    }