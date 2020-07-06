package kun.kt.busticket.feature.buyticket

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kun.kt.busticket.basedata.DataState
import kun.kt.busticket.baseusecase.usecase.BuyTicket
import kun.kt.busticket.baseusecase.usecase.ExtendTicket
import kun.kt.busticket.baseusecase.usecase.GetBus
import kun.kt.busticket.baseusecase.usecase.GetCities
import kun.kt.busticket.model.*
import kun.kt.busticket.util.onError
import kun.kt.busticket.util.onSuccess
import javax.inject.Inject

class BuyTicketViewModel @Inject constructor(
    private val _buyTicket: BuyTicket,
    private val _extendTicket: ExtendTicket,
    private val _getCities: GetCities,
    private val _getBus: GetBus
) : ViewModel() {
    val citiesLiveData by lazy { MutableLiveData<DataState<List<City>>>() }
    val buyTicketResult by lazy { MutableLiveData<DataState<BuyTicketResponse>>() }
    val busLiveData by lazy { MutableLiveData<DataState<List<Bus>>>() }
    fun buyTicket(wrapper: PurchaseTicketWrapper) {
        _buyTicket(wrapper = wrapper,
            onSuccess = {
                buyTicketResult.onSuccess(it)
            }, onError = {
                buyTicketResult.onError(t = it)
            })
    }

    fun getCities() {
        _getCities({
            citiesLiveData.onSuccess(it)
        }, {
            citiesLiveData.onError(it)
        })
    }

    fun getBus(type: GetBus.Type) {
        _getBus(type, {
            it?.let {
                busLiveData.onSuccess(it)
            }
        }, {
            busLiveData.onError(it)
        })
    }
}