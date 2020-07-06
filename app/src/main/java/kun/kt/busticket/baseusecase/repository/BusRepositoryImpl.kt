package kun.kt.busticket.baseusecase.repository

import kun.kt.busticket.basedata.datasource.BusDataSource
import kun.kt.busticket.basedata.entities.ListBusComingResponse
import kun.kt.busticket.basedata.entities.ListBusNumberResponse
import kun.kt.busticket.basedata.remote.ApiCallBack
import javax.inject.Inject

class BusRepositoryImpl @Inject constructor(val remote: BusDataSource) :
    BusRepository {
    override fun getBusNumber(
        onSuccess: (data: ListBusNumberResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getBusNumber(object : ApiCallBack<ListBusNumberResponse>() {
            override fun onSuccess(t: ListBusNumberResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }

    override fun getBusComing(
        onSuccess: (data: ListBusComingResponse) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        remote.getBusComing(object : ApiCallBack<ListBusComingResponse>() {
            override fun onSuccess(t: ListBusComingResponse) {
                onSuccess(t)
            }

            override fun onError(throwable: Throwable) {
                onError(throwable)
            }

        })
    }
}