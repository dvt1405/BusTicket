package kun.kt.busticket.model

data class Ticket(
    val busNo: String,
    val expiredDate: String,
    val id: Int,
    val ticketType: TicketType
)