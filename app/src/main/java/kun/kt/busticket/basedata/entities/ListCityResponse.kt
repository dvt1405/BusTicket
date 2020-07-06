package kun.kt.busticket.basedata.entities

data class ListCityResponse(
    val cities: List<City>,
    val code: String,
    val description: String
)
