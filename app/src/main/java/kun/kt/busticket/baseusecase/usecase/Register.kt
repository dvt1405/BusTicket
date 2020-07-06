package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.baseusecase.repository.CustomerRepository
import kun.kt.busticket.model.Customer
import javax.inject.Inject

class Register @Inject constructor(val repository: CustomerRepository) {
    operator fun invoke(
        data: Customer,
        onSuccess: () -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        val requestData = RegisterCustomerRequest(
            data.image,
            data.name,
            data.phone
        )
        repository.register(
            request = requestData,
            onSuccess = {
                onSuccess()
            },
            onError = onError
        )
    }
}