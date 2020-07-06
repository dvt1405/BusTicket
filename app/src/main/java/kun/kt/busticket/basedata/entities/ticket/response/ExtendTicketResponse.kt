package kun.kt.busticket.basedata.entities.ticket.response

data class ExtendTicketResponse(
    val buyCode: Int,
    val code: String,
    val description: String,
    val ticketId: Int,
    val value: Int
)