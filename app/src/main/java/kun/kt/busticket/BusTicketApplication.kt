package kun.kt.busticket

import android.app.Application
import kun.kt.busticket.basedata.di.LocalModule
import kun.kt.busticket.basedata.di.RemoteDataSourceModule
import kun.kt.busticket.basedata.di.RetrofitModule
import kun.kt.busticket.baseusecase.di.RepositoryModule
import kun.kt.busticket.baseusecase.di.UseCaseModule
import kun.kt.busticket.di.DaggerAppComponent
import kun.kt.busticket.di.buyticket.BuyTicketModule
import kun.kt.busticket.di.login.LoginModule

class BusTicketApplication : Application() {
    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .localModule(LocalModule(this))
            .retrofitModule(RetrofitModule())
            .useCaseModule(UseCaseModule())
            .repositoryModule(RepositoryModule())
            .remoteDataSourceModule(RemoteDataSourceModule())
            .build()
    }
    val loginComponent by lazy {
        appComponent.plus(LoginModule())
    }
    val buyTicketComponent by lazy {
        appComponent.plus(BuyTicketModule())
    }

    override fun onCreate() {
        super.onCreate()
    }
}