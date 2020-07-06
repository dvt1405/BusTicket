package kun.kt.busticket.basedata.entities.ticket.response

import kun.kt.busticket.basedata.entities.ticket.Ticket

data class ListTicketResponse(
    val code: String,
    val description: String,
    val tickets: List<Ticket>
)
