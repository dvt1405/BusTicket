package kun.kt.busticket.baseusecase.di

import dagger.Module
import dagger.Provides
import kun.kt.busticket.basedata.datasource.BusDataSource
import kun.kt.busticket.basedata.datasource.CustomerDataSource
import kun.kt.busticket.basedata.datasource.TicketDataSource
import kun.kt.busticket.baseusecase.repository.*
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesBusRepository(remoteBus: BusDataSource): BusRepository =
        BusRepositoryImpl(remoteBus)

    @Provides
    @Singleton
    fun providesCustomerRepository(remoteCustomer: CustomerDataSource): CustomerRepository =
        CustomerRepositoryImpl(remoteCustomer)

    @Provides
    @Singleton
    fun providesTicketRepository(remoteTicket: TicketDataSource): TicketRepository =
        TicketRepositoryImpl(remoteTicket)
}