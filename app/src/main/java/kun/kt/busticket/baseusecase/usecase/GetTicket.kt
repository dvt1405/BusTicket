package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.baseusecase.repository.TicketRepository
import kun.kt.busticket.model.Ticket
import kun.kt.busticket.model.getTicketType
import javax.inject.Inject

class GetTicket @Inject constructor(val repository: TicketRepository) {
    operator fun invoke(
        phone: String,
        onSuccess: (list: List<Ticket>) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.getTicket(
            phone,
            onError = onError,
            onSuccess = { response ->
                val list = response.tickets.map {
                    val ticketType = getTicketType(it.ticketType)
                    Ticket(it.busNo, it.expỉedDate, it.id, ticketType)
                }
                onSuccess(list)
            }
        )
    }
}