package kun.kt.busticket.di

import dagger.Component
import kun.kt.busticket.basedata.di.LocalModule
import kun.kt.busticket.basedata.di.RemoteDataSourceModule
import kun.kt.busticket.basedata.di.RetrofitModule
import kun.kt.busticket.baseusecase.di.RepositoryModule
import kun.kt.busticket.baseusecase.di.UseCaseModule
import kun.kt.busticket.di.buyticket.BuyTicketComponent
import kun.kt.busticket.di.buyticket.BuyTicketModule
import kun.kt.busticket.di.login.LoginModule
import kun.kt.busticket.di.login.LoginSubComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(UseCaseModule::class),
        (RepositoryModule::class),
        (RetrofitModule::class),
        (RemoteDataSourceModule::class),
        (LocalModule::class)]
)
interface AppComponent {
    fun plus(loginModule: LoginModule): LoginSubComponent
    fun plus(buyTicketModule: BuyTicketModule): BuyTicketComponent
}