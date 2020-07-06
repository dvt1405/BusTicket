package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.baseusecase.repository.TicketRepository
import kun.kt.busticket.model.BuyTicketResponse
import kun.kt.busticket.model.PurchaseTicketWrapper
import kun.kt.busticket.model.TicketType
import javax.inject.Inject

class ExtendTicket @Inject constructor(val repository: TicketRepository) {
    operator fun invoke(
        bankId: Int,
        expiredDate: String,
        phone: String,
        ticketType: TicketType,
        ticketId: Int,
        onSuccess: (response: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.extendTicket(
            extendTicketRequest = ExtendTicketRequest(
                bankId, expiredDate, phone, ticketType.value, ticketId
            ),
            onSuccess = {
                onSuccess(
                    BuyTicketResponse(
                        buyCode = it.buyCode,
                        ticketId = it.ticketId,
                        value = it.value
                    )
                )
            },
            onError = onError
        )
    }

    operator fun invoke(
        purchaseTicketWrapper: PurchaseTicketWrapper,
        onSuccess: (response: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.extendTicket(
            extendTicketRequest = ExtendTicketRequest(
                purchaseTicketWrapper.bankId,
                purchaseTicketWrapper.expiredDate,
                purchaseTicketWrapper.phone,
                purchaseTicketWrapper.ticketType.value,
                purchaseTicketWrapper.ticketId ?: -1
            ),
            onSuccess = {
                onSuccess(
                    BuyTicketResponse(
                        buyCode = it.buyCode,
                        ticketId = it.ticketId,
                        value = it.value
                    )
                )
            },
            onError = onError
        )
    }
}