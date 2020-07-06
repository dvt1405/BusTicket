package kun.kt.busticket.model

data class BuyTicketResponse(
    val buyCode: Int,
    val ticketId: Int,
    val value: Int
) {
}