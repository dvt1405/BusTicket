package kun.kt.busticket.di.login

import dagger.Module
import dagger.Provides
import kun.kt.busticket.basedata.local.BusTicketPreference
import kun.kt.busticket.baseusecase.usecase.GetCustomer
import kun.kt.busticket.baseusecase.usecase.Register
import kun.kt.busticket.feature.login.LoginViewModelFactory

@Module
class LoginModule {
    @Provides
    @LoginScope
    fun providesLoginVmFactory(
        _register: Register, _getCustomer: GetCustomer, sharedPreferences: BusTicketPreference
    ) = LoginViewModelFactory(_register, _getCustomer, sharedPreferences)
}