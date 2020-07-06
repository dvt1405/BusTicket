package kun.kt.busticket.basedata.entities

data class ListBusNumberResponse(
    val busNumbers: List<Bus>?,
    val code: String?,
    val description: String?
)

