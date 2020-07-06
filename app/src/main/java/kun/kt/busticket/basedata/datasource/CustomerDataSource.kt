package kun.kt.busticket.basedata.datasource

import kun.kt.busticket.basedata.remote.ApiCallBack
import kun.kt.busticket.basedata.entities.ListCityResponse
import kun.kt.busticket.basedata.entities.customer.Customer
import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.basedata.entities.customer.response.RegisterCustomerResponse

interface CustomerDataSource {
    fun getCities(callBack: ApiCallBack<ListCityResponse>)
    fun getCustomer(phone: String, callBack: ApiCallBack<Customer>)
    fun register(
        registerCustomerRequest: RegisterCustomerRequest,
        callBack: ApiCallBack<RegisterCustomerResponse>
    )
}