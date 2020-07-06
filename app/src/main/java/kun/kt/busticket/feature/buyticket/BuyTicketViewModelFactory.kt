package kun.kt.busticket.feature.buyticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kun.kt.busticket.baseusecase.usecase.BuyTicket
import kun.kt.busticket.baseusecase.usecase.ExtendTicket
import kun.kt.busticket.baseusecase.usecase.GetBus
import kun.kt.busticket.baseusecase.usecase.GetCities
import javax.inject.Inject

class BuyTicketViewModelFactory @Inject constructor(
    private val _buyTicket: BuyTicket,
    private val _extendTicket: ExtendTicket,
    private val _getCities: GetCities,
    private val _getBus: GetBus
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        BuyTicketViewModel(_buyTicket, _extendTicket, _getCities, _getBus) as T
}