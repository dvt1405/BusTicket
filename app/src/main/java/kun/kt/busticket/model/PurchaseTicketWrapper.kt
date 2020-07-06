package kun.kt.busticket.model

data class PurchaseTicketWrapper(
    var bankId: Int,
    var busNo: String?,
    var customerId: Int,
    var expiredDate: String,
    var phone: String,
    var ticketType: TicketType,
    var ticketId: Int?
) {
}