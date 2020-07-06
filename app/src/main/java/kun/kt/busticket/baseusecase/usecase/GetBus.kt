package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.baseusecase.repository.BusRepository
import kun.kt.busticket.model.Bus
import javax.inject.Inject

class GetBus @Inject constructor(val repository: BusRepository) {
    operator fun invoke(
        type: Type,
        onSuccess: (buses: List<Bus>?) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        when (type) {
            Type.BUS_NUMBER -> {
                repository.getBusNumber(
                    onSuccess = { response ->
                        onSuccess(response.busNumbers?.map {
                            Bus(
                                it.busNo,
                                it.desc,
                                it.bks,
                                it.code
                            )
                        })
                    },
                    onError = onError
                )
            }
            Type.BUS_COMING -> {
                repository.getBusComing(
                    onSuccess = { response ->
                        onSuccess(response.bus.map {
                            Bus(
                                it.busNo,
                                it.desc,
                                it.bks,
                                it.code
                            )
                        })
                    },
                    onError = onError
                )
            }
        }

    }

    enum class Type {
        BUS_NUMBER, BUS_COMING
    }
}