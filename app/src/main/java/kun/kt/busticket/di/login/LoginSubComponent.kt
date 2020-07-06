package kun.kt.busticket.di.login

import dagger.Module
import dagger.Subcomponent
import kun.kt.busticket.di.login.LoginScope
import kun.kt.busticket.feature.login.LoginActivity
import kun.kt.busticket.feature.login.register.FragmentRegister

@Subcomponent(modules = [(LoginModule::class)])
@LoginScope
interface LoginSubComponent {
    fun inject(login: LoginActivity)
    fun inject(fragment: FragmentRegister)
}