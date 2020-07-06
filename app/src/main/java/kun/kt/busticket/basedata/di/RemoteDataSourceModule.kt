package kun.kt.busticket.basedata.di

import dagger.Module
import dagger.Provides
import kun.kt.busticket.basedata.API
import kun.kt.busticket.basedata.datasource.BusDataSource
import kun.kt.busticket.basedata.datasource.CustomerDataSource
import kun.kt.busticket.basedata.datasource.TicketDataSource
import kun.kt.busticket.basedata.remote.BusDataSourceImpl
import kun.kt.busticket.basedata.remote.CustomerDataSourceImpl
import kun.kt.busticket.basedata.remote.TicketDataSourceImpl
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideCustomerDataSource(api: API): CustomerDataSource = CustomerDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideBusDataSource(api: API): BusDataSource = BusDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideTicketDataSource(api: API): TicketDataSource = TicketDataSourceImpl(api)
}