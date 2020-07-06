package kun.kt.busticket.basedata.local

import android.content.Context
import android.content.SharedPreferences

class BusTicketPreference(private val context: Context) {
    companion object {
        const val SHARE_PREF_NAME = "bus_ticket"
        const val PHONE_SHARED_PREF = "phone"
    }

    private val preference: SharedPreferences =
        context.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE)

    fun savePhone(phone: String) = preference.edit()
        .putString(PHONE_SHARED_PREF, phone)
        .apply()

    fun getPhone() = preference.getString(PHONE_SHARED_PREF, "")
    fun deletePhone() = preference.edit().remove(PHONE_SHARED_PREF).apply()
}