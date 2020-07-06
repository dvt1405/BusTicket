package kun.kt.busticket.feature.buyticket.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_start_buy_ticket.view.*
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseFragment
import kun.kt.busticket.feature.buyticket.BuyTicketActivity
import kun.kt.busticket.feature.buyticket.fragment.buyTicket.BuyTicketFragment

class StartBuyTicketFragment() : BaseFragment(R.layout.fragment_start_buy_ticket) {
    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

    override fun initAction(view: View, savedInstanceState: Bundle?) {
        view.btn_buy_ticket.setOnClickListener {
            (activity as BuyTicketActivity).addFragment(
                BuyTicketFragment(),
                BuyTicketFragment::class.java.name
            )
        }
    }
}