package kun.kt.busticket.basedata.entities

data class ListBusComingResponse(
    val bus: List<Bus>,
    val code: String,
    val description: String
)
