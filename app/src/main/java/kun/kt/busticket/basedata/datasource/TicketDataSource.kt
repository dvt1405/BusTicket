package kun.kt.busticket.basedata.datasource

import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.basedata.entities.ticket.response.BusTicketTypeResponse
import kun.kt.busticket.basedata.entities.ticket.response.BuyTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ExtendTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ListTicketResponse
import kun.kt.busticket.basedata.remote.ApiCallBack

interface TicketDataSource {
    fun getTicketType(callback: ApiCallBack<BusTicketTypeResponse>)
    fun getTicket(phone: String, callBack: ApiCallBack<ListTicketResponse>)
    fun buyTicket(buyTicketRequest: BuyTicketRequest, callBack: ApiCallBack<BuyTicketResponse>)
    fun extendTicket(
        extendTicketRequest: ExtendTicketRequest,
        callBack: ApiCallBack<ExtendTicketResponse>
    )

    fun getBusTicketType(callBack: ApiCallBack<BusTicketTypeResponse>)
}