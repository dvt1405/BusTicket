package kun.kt.busticket.baseusecase.repository

import kun.kt.busticket.basedata.entities.ListBusComingResponse
import kun.kt.busticket.basedata.entities.ListBusNumberResponse

interface BusRepository {
    fun getBusNumber(onSuccess: (data: ListBusNumberResponse) -> Unit, onError: (throwable: Throwable) -> Unit)
    fun getBusComing(onSuccess: (data: ListBusComingResponse) -> Unit, onError: (throwable: Throwable) -> Unit)
}