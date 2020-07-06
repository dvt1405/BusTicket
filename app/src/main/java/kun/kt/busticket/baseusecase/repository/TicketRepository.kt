package kun.kt.busticket.baseusecase.repository

import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.basedata.entities.ticket.response.BusTicketTypeResponse
import kun.kt.busticket.basedata.entities.ticket.response.BuyTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ExtendTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ListTicketResponse

interface TicketRepository {
    fun getTicketType(
        onSuccess: (data: BusTicketTypeResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun getTicket(
        phone: String,
        onSuccess: (data: ListTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun buyTicket(
        buyTicketRequest: BuyTicketRequest,
        onSuccess: (data: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun extendTicket(
        extendTicketRequest: ExtendTicketRequest,
        onSuccess: (data: ExtendTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun getBusTicketType(
        onSuccess: (data: BusTicketTypeResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )
}