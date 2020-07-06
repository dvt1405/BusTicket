package kun.kt.busticket.baseusecase.repository

import android.util.Log
import kun.kt.busticket.basedata.datasource.CustomerDataSource
import kun.kt.busticket.basedata.entities.ListCityResponse
import kun.kt.busticket.basedata.entities.customer.Customer
import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.basedata.entities.customer.response.RegisterCustomerResponse
import kun.kt.busticket.basedata.remote.ApiCallBack
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(val remote: CustomerDataSource) :
    CustomerRepository {
    override fun getCities(
        onSuccess: (data: ListCityResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getCities(object : ApiCallBack<ListCityResponse>() {
            override fun onSuccess(t: ListCityResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun getCustomer(
        phone: String,
        onSuccess: (data: Customer) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getCustomer(phone, object : ApiCallBack<Customer>() {
            override fun onSuccess(t: Customer) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun register(
        request: RegisterCustomerRequest,
        onSuccess: (data: RegisterCustomerResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.register(request, object : ApiCallBack<RegisterCustomerResponse>() {
            override fun onSuccess(t: RegisterCustomerResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }
}