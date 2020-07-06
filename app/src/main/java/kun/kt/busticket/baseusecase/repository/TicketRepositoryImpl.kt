package kun.kt.busticket.baseusecase.repository

import kun.kt.busticket.basedata.datasource.TicketDataSource
import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.basedata.entities.ticket.response.BusTicketTypeResponse
import kun.kt.busticket.basedata.entities.ticket.response.BuyTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ExtendTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ListTicketResponse
import kun.kt.busticket.basedata.remote.ApiCallBack
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(val remote: TicketDataSource) :
    TicketRepository {
    override fun getTicketType(
        onSuccess: (data: BusTicketTypeResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getTicketType(object : ApiCallBack<BusTicketTypeResponse>() {
            override fun onSuccess(t: BusTicketTypeResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun getTicket(
        phone: String,
        onSuccess: (data: ListTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getTicket(phone, object : ApiCallBack<ListTicketResponse>() {
            override fun onSuccess(t: ListTicketResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun buyTicket(
        buyTicketRequest: BuyTicketRequest,
        onSuccess: (data: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.buyTicket(buyTicketRequest, object : ApiCallBack<BuyTicketResponse>() {
            override fun onSuccess(t: BuyTicketResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun extendTicket(
        extendTicketRequest: ExtendTicketRequest,
        onSuccess: (data: ExtendTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.extendTicket(extendTicketRequest, object : ApiCallBack<ExtendTicketResponse>() {
            override fun onSuccess(t: ExtendTicketResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun getBusTicketType(
        onSuccess: (data: BusTicketTypeResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getBusTicketType(object : ApiCallBack<BusTicketTypeResponse>() {
            override fun onSuccess(t: BusTicketTypeResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }
        })
    }
}