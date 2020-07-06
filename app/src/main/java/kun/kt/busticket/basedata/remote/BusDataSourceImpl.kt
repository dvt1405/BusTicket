package kun.kt.busticket.basedata.remote

import kun.kt.busticket.basedata.API
import kun.kt.busticket.basedata.datasource.BusDataSource
import kun.kt.busticket.basedata.entities.ListBusComingResponse
import kun.kt.busticket.basedata.entities.ListBusNumberResponse
import javax.inject.Inject

class BusDataSourceImpl @Inject constructor(val api: API) : BusDataSource {

    override fun getBusNumber(callback: ApiCallBack<ListBusNumberResponse>) {
        api.getBusNumber().enqueue(callback.enqueueApi)
    }

    override fun getBusComing(callback: ApiCallBack<ListBusComingResponse>) {
        api.getBusComing().enqueue(callback.enqueueApi)
    }
}