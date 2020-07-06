package kun.kt.busticket.basedata.entities.ticket.request

data class ExtendTicketRequest(
    val bankId: Int,
    val expiredDate: String,
    val phone: String,
    val ticketType: Int,
    val tikectId: Int
)