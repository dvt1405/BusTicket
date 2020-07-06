package kun.kt.busticket.basedata.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kun.kt.busticket.basedata.local.BusTicketPreference
import javax.inject.Singleton

@Module
class LocalModule(private val context: Context) {
    @Provides
    @Singleton
    fun providesSharePref() = BusTicketPreference(context)
}