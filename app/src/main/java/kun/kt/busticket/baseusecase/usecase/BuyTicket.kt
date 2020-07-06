package kun.kt.busticket.baseusecase.usecase

import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.baseusecase.repository.TicketRepository
import kun.kt.busticket.model.BuyTicketResponse
import kun.kt.busticket.model.PurchaseTicketWrapper
import javax.inject.Inject

class BuyTicket @Inject constructor(val repository: TicketRepository) {
    operator fun invoke(
        wrapper: PurchaseTicketWrapper,
        onSuccess: (successInfo: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.buyTicket(
            buyTicketRequest = BuyTicketRequest(
                bankId = wrapper.bankId,
                busNo = wrapper.busNo,
                customerId = wrapper.customerId,
                expiredDate = wrapper.expiredDate,
                phone = wrapper.phone,
                ticketType = wrapper.ticketType.value
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
        bankId: Int,
        busNo: String,
        customerId: Int,
        expiredDate: String,
        phone: String,
        ticketType: Int,
        onSuccess: (successInfo: BuyTicketResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        repository.buyTicket(
            buyTicketRequest = BuyTicketRequest(
                bankId, busNo, customerId, expiredDate, phone, ticketType
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