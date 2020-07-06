package kun.kt.busticket.basedata.entities.ticket.request

/**
 * bankId là cấu hình theo từng app.
 * CustomerId : lấy giá trị id ở api lấy thông tin khách hàng.
 * ticketType: loại vé : 0:monthly;1:weekly;2:daily;3:once
 * busNo: lấy ở api danh sách tuyến bus.
 *
 * **/

data class BuyTicketRequest(
    val bankId: Int,
    val busNo: String?,
    val customerId: Int,
    val expiredDate: String?,
    val phone: String?,
    val ticketType: Int
)