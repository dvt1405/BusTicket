package kun.kt.busticket.feature.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import kun.kt.busticket.basecomponent.BaseViewModel
import kun.kt.busticket.basedata.DataState
import kun.kt.busticket.basedata.local.BusTicketPreference
import kun.kt.busticket.baseusecase.usecase.GetCustomer
import kun.kt.busticket.baseusecase.usecase.Register
import kun.kt.busticket.model.Customer
import kun.kt.busticket.util.onError
import kun.kt.busticket.util.onSuccess
import retrofit2.HttpException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val _register: Register,
    private val _getCustomer: GetCustomer,
    val sharedPreferences: BusTicketPreference
) : BaseViewModel() {
    val registerState = MutableLiveData<DataState<Boolean>>()
    val getCustomerState = MutableLiveData<DataState<Customer>>()

    fun register(data: Customer) = _register(data = data,
        onSuccess = {
            registerState.onSuccess(true)
        }, onError = {
            registerState.onError(it)
        })

    fun getCustomer(phone: String, onSuccess: () -> Unit) =
        _getCustomer(phone = phone, onSuccess = {
            getCustomerState.onSuccess(it)
        }, onError = {
            getCustomerState.onError(it)
        })

    fun checkPhoneNum(): Boolean = !sharedPreferences.getPhone().isNullOrEmpty()
    fun updatePhoneNum(phone: String) = sharedPreferences.savePhone(phone)

}