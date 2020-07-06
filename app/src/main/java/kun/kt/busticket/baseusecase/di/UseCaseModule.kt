package kun.kt.busticket.baseusecase.di

import dagger.Module
import dagger.Provides
import kun.kt.busticket.baseusecase.repository.BusRepository
import kun.kt.busticket.baseusecase.repository.CustomerRepository
import kun.kt.busticket.baseusecase.repository.TicketRepository
import kun.kt.busticket.baseusecase.usecase.*
import org.intellij.lang.annotations.PrintFormat
import javax.inject.Inject
import javax.inject.Singleton

@Module
class UseCaseModule @Inject constructor(
) {
    @Provides
    @Singleton
    fun providesBuyTicket(ticketRepository: TicketRepository) = BuyTicket(ticketRepository)

    @Provides
    @Singleton
    fun providesExtendTicket(ticketRepository: TicketRepository) = ExtendTicket(ticketRepository)

    @Provides
    @Singleton
    fun providesGetBus(busRepository: BusRepository) = GetBus(busRepository)

    @Provides
    @Singleton
    fun providesGetCities(customerRepository: CustomerRepository) = GetCities(customerRepository)

    @Provides
    @Singleton
    fun getCustomer(customerRepository: CustomerRepository) = GetCustomer(customerRepository)

    @Provides
    @Singleton
    fun providesGetTicket(ticketRepository: TicketRepository) = GetTicket(ticketRepository)

    @Provides
    @Singleton
    fun providesGetTicketType(ticketRepository: TicketRepository) = GetTicketType(ticketRepository)

    @Provides
    @Singleton
    fun providesRegister(customerRepository: CustomerRepository) = Register(customerRepository)


}