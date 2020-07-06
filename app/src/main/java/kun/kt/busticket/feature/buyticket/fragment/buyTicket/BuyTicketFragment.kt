package kun.kt.busticket.feature.buyticket.fragment.buyTicket

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_buy_ticket.view.*
import kun.kt.busticket.R
import kun.kt.busticket.basecomponent.BaseFragment
import kun.kt.busticket.basedata.DataState
import kun.kt.busticket.baseusecase.usecase.GetBus
import kun.kt.busticket.feature.buyticket.BuyTicketViewModel
import kun.kt.busticket.model.*
import roxwin.tun.baseui.dialog.ProgressDialog
import java.lang.Exception

class BuyTicketFragment() : BaseFragment(R.layout.fragment_buy_ticket) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(BuyTicketViewModel::class.java)
    }

    private var listCities: List<City>? = null
    private var listBusBNum: List<Bus>? = null
    private val progressDialog by lazy {
        ProgressDialog(requireContext(), false)
    }
    private val wrapper: PurchaseTicketWrapper by lazy {
        PurchaseTicketWrapper(
            bankId = 1,
            busNo = "",
            customerId = 1,
            expiredDate = "",
            phone = "",
            ticketId = 1,
            ticketType = TicketType.MONTHLY
        )
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {

    }

    override fun initAction(view: View, savedInstanceState: Bundle?) {
        view.appCompatSpinner?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    try {

                    } catch (e: Exception) {

                    }
                }

            }
        view.select_ticket_type_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.one_line -> {
                    view.total_money.text = "60.000 VND"
                    wrapper.ticketType = TicketType.MONTHLY
                }
                R.id.interline -> {
                    view.total_money.text = "120.000 VND"
                    wrapper.ticketType = TicketType.MONTHLY
                }
                R.id.in_turn -> {
                    view.total_money.text = "7.000 VND"
                    wrapper.ticketType = TicketType.ONCE

                }
            }
        }
        view.btn_buy_ticket.setOnClickListener {
            viewModel.buyTicket(
                wrapper
            )
        }
        view.select_bus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                listBusBNum?.let {
                    wrapper.busNo = it[position].number
                }
            }

        }
        viewModel.citiesLiveData.observe(viewLifecycleOwner, Observer {
            handleListCity(it)
        })
        viewModel.busLiveData.observe(viewLifecycleOwner, Observer {
            handleListBusNumber(it)
        })
        viewModel.buyTicketResult.observe(viewLifecycleOwner, Observer {
            handlePurchaseTicket(it)
        })
    }

    private fun handlePurchaseTicket(data: DataState<BuyTicketResponse>?) {
        when (data) {
            is DataState.Success -> {
                Toast.makeText(requireContext(), "Buy success", Toast.LENGTH_SHORT).show()
            }
            is DataState.Error -> {

            }
            is DataState.ApiError -> {

            }
        }
    }

    private fun handleListBusNumber(data: DataState<List<Bus>>?) {
        when (data) {
            is DataState.Success -> {
                val adapter = ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    data.value.map { it.number })
                listBusBNum = data.value
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                requireView().select_bus.adapter = adapter
            }
            is DataState.Error -> {

            }
        }
    }

    private fun handleListCity(data: DataState<List<City>>) {
        when (data) {
            is DataState.Success -> {
                val adapter = ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    data.value.map { it.name })
                listCities = data.value
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                requireView().appCompatSpinner.adapter = adapter
            }
            is DataState.Error -> {

            }
        }
    }
}