package kun.kt.busticket.baseusecase.repository

import kun.kt.busticket.basedata.entities.ListCityResponse
import kun.kt.busticket.basedata.entities.customer.Customer
import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.basedata.entities.customer.response.RegisterCustomerResponse

interface CustomerRepository {
    fun getCities(
        onSuccess: (data: ListCityResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun getCustomer(
        phone: String,
        onSuccess: (data: Customer) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )

    fun register(
        request: RegisterCustomerRequest,
        onSuccess: (data: RegisterCustomerResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    )
}