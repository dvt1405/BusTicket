package kun.kt.busticket.basedata.entities.ticket.response

import com.google.gson.Gson

data class BusTicketTypeResponse(
    val busTicketType: List<BusTicketType>,
    val code: String,
    val description: String
)

data class BusTicketType(
    val name: String,
    val type: Int
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}