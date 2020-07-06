package kun.kt.busticket.basedata.remote

import kun.kt.busticket.basedata.API
import kun.kt.busticket.basedata.datasource.CustomerDataSource
import kun.kt.busticket.basedata.entities.ListCityResponse
import kun.kt.busticket.basedata.entities.customer.Customer
import kun.kt.busticket.basedata.entities.customer.request.PhoneRequest
import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.basedata.entities.customer.response.RegisterCustomerResponse
import javax.inject.Inject

class CustomerDataSourceImpl @Inject constructor(val api: API) : CustomerDataSource {
    override fun getCities(callBack: ApiCallBack<ListCityResponse>) {
        api.getCities().enqueue(callBack.enqueueApi)
    }

    override fun getCustomer(
        phone: String,
        callBack: ApiCallBack<Customer>
    ) {
        api.getCustomer(PhoneRequest(phone)).enqueue(callBack.enqueueApi)
    }

    override fun register(
        registerCustomerRequest: RegisterCustomerRequest,
        callBack: ApiCallBack<RegisterCustomerResponse>
    ) {
        api.register(registerCustomerRequest).enqueue(callBack.enqueueApi)
    }
}