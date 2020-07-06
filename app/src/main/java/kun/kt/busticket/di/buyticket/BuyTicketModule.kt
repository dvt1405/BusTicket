package kun.kt.busticket.di.buyticket

import dagger.Module
import dagger.Provides
import kun.kt.busticket.baseusecase.usecase.BuyTicket
import kun.kt.busticket.baseusecase.usecase.ExtendTicket
import kun.kt.busticket.baseusecase.usecase.GetBus
import kun.kt.busticket.baseusecase.usecase.GetCities
import kun.kt.busticket.feature.buyticket.BuyTicketViewModelFactory

@Module
class BuyTicketModule {
    @Provides
    @BuyTicketScope
    fun providesBuyTicket(
        _buyTicket: BuyTicket,
        _extendTicket: ExtendTicket,
        _getCities: GetCities,
        _getBus: GetBus
    ) = BuyTicketViewModelFactory(_buyTicket, _extendTicket, _getCities, _getBus)
}