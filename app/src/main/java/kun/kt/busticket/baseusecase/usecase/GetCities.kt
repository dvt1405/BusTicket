package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.baseusecase.repository.CustomerRepository
import kun.kt.busticket.model.City
import javax.inject.Inject

class GetCities @Inject constructor(val repository: CustomerRepository) {
    operator fun invoke(onSuccess: (List<City>) -> Unit, onError: (throwable: Throwable) -> Unit) {
        repository.getCities(
            onSuccess = {
                val list = it.cities.map { City(it.code, it.name) }
                onSuccess(list)
            },
            onError = onError
        )
    }
}