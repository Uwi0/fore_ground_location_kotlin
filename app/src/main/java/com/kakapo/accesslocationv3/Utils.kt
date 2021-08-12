package com.kakapo.accesslocationv3

import android.content.Context
import android.location.Location
import androidx.core.content.edit

fun Location?.toText(): String {
    return if (this != null) {
        "($latitude, $longitude)"
    } else {
        "Unknown Location"
    }
}

internal object SharedPreferenceUtil {
    const val KEY_FOREGROUND_ENABLED = "tracking_foreground_location"


    fun getLocationTrackingSharePref(context: Context): Boolean =
        context.getSharedPreferences(
            context.getString(R.string.preference_file_key), Context.MODE_PRIVATE
        ).getBoolean(KEY_FOREGROUND_ENABLED, false)

    fun saveLocationTrackingPref(context: Context, requestingLocationUpdate: Boolean) =
        context.getSharedPreferences(
            context.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        ).edit {
            putBoolean(KEY_FOREGROUND_ENABLED, requestingLocationUpdate)
        }
}