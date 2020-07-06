package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.baseusecase.repository.TicketRepository
import kun.kt.busticket.model.TicketType
import java.lang.IllegalStateException
import javax.inject.Inject

class GetTicketType @Inject constructor(val ticketRepository: TicketRepository) {
    operator fun invoke(
        onSuccess: (types: List<TicketType>) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        ticketRepository.getBusTicketType(
            onSuccess = {
                val list = it.busTicketType.map {
                    when (it.type) {
                        0 -> TicketType.MONTHLY
                        1 -> TicketType.WEEKLY
                        2 -> TicketType.DAILY
                        3 -> TicketType.ONCE
                        else -> throw IllegalStateException("Unknow ticket type: ${it.toString()}")
                    }
                }
                onSuccess(list)
            }, onError = onError
        )
    }
}