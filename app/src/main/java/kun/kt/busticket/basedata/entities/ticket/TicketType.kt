package kun.kt.busticket.basedata.entities.ticket

/**
 * 0:monthly;1:weekly;2:daily;3:once
 * **/
enum class TicketType(val value: Int) {
    MONTHLY(0),
    WEEKLY(1),
    DAILY(2),
    ONCE(3)
}