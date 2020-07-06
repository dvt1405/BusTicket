package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.baseusecase.repository.CustomerRepository
import kun.kt.busticket.model.Customer
import javax.inject.Inject

class GetCustomer @Inject constructor(val repository: CustomerRepository) {
    operator fun invoke(
        phone: String,
        onSuccess: (customer: Customer) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.getCustomer(
            phone = phone,
            onSuccess = {
                onSuccess(
                    Customer(
                        image = it.image ?: "",
                        name = it.name ?: "",
                        phone = it.phone ?: ""
                    )
                )
            },
            onError = onError
        )
    }
}