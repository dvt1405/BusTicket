package kun.kt.busticket.model

import java.lang.IllegalStateException

/**
 * 0:monthly;1:weekly;2:daily;3:once
 * **/
enum class TicketType(val value: Int) {
    MONTHLY(0),
    WEEKLY(1),
    DAILY(2),
    ONCE(3)
}

fun getTicketType(value: Int) = when (value) {
    0 -> TicketType.MONTHLY
    1 -> TicketType.WEEKLY
    2 -> TicketType.DAILY
    3 -> TicketType.ONCE
    else -> throw IllegalStateException("Unknow ticket type: $value")
}