package kun.kt.busticket.di.buyticket

import dagger.Subcomponent
import kun.kt.busticket.feature.buyticket.BuyTicketActivity

@Subcomponent(modules = [(BuyTicketModule::class)])
@BuyTicketScope
interface BuyTicketComponent {
    fun inject(buyTicketActivity: BuyTicketActivity)
}