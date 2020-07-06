package kun.kt.busticket.feature.buyticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kun.kt.busticket.BusTicketApplication
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseTicketActivity
import kun.kt.busticket.baseusecase.usecase.GetBus
import kun.kt.busticket.feature.buyticket.fragment.StartBuyTicketFragment
import kun.kt.busticket.model.Bus
import javax.inject.Inject

class BuyTicketActivity : BaseTicketActivity() {
    override val fragmentContainer: Int = R.id.fragment_container
    override val backStack: String = this::class.java.name

    @Inject
    lateinit var viewModelFactory: BuyTicketViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(BuyTicketViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)
        (application as BusTicketApplication).buyTicketComponent.inject(this)
        viewModel.getCities()
        viewModel.getBus(GetBus.Type.BUS_NUMBER)
        addFragment(StartBuyTicketFragment(), StartBuyTicketFragment::class.java.name)
    }
}
