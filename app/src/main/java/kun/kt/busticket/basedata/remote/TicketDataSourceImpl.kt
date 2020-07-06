package kun.kt.busticket.basedata.remote

import kun.kt.busticket.basedata.API
import kun.kt.busticket.basedata.datasource.TicketDataSource
import kun.kt.busticket.basedata.entities.customer.request.PhoneRequest
import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.basedata.entities.ticket.response.BusTicketTypeResponse
import kun.kt.busticket.basedata.entities.ticket.response.BuyTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ExtendTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ListTicketResponse
import javax.inject.Inject

class TicketDataSourceImpl @Inject constructor(val api: API) : TicketDataSource {
    override fun getTicketType(callback: ApiCallBack<BusTicketTypeResponse>) {
        api.getBusTicketType().enqueue(callback.enqueueApi)
    }

    override fun getTicket(phone: String, callBack: ApiCallBack<ListTicketResponse>) {
        api.getTicket(PhoneRequest(phone)).enqueue(callBack.enqueueApi)
    }

    override fun buyTicket(
        buyTicketRequest: BuyTicketRequest,
        callBack: ApiCallBack<BuyTicketResponse>
    ) {
        api.buyTicket(buyTicketRequest).enqueue(callBack.enqueueApi)
    }

    override fun extendTicket(
        extendTicketRequest: ExtendTicketRequest,
        callBack: ApiCallBack<ExtendTicketResponse>
    ) {
        api.extendTicket(extendTicketRequest).enqueue(callBack.enqueueApi)
    }

    override fun getBusTicketType(callBack: ApiCallBack<BusTicketTypeResponse>) {
        api.getBusTicketType().enqueue(callBack.enqueueApi)
    }

}