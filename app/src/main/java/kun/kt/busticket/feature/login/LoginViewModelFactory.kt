package kun.kt.busticket.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kun.kt.busticket.basedata.local.BusTicketPreference
import kun.kt.busticket.baseusecase.usecase.GetCustomer
import kun.kt.busticket.baseusecase.usecase.Register
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    private val _register: Register,
    private val _getCustomer: GetCustomer,
    private val sharedPreferences: BusTicketPreference
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        LoginViewModel(_register, _getCustomer,sharedPreferences) as T
}