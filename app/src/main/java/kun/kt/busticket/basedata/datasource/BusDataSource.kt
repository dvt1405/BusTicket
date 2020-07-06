package kun.kt.busticket.basedata.datasource

import kun.kt.busticket.basedata.entities.ListBusComingResponse
import kun.kt.busticket.basedata.remote.ApiCallBack
import kun.kt.busticket.basedata.entities.ListBusNumberResponse

interface BusDataSource {
    fun getBusNumber(callback: ApiCallBack<ListBusNumberResponse>)
    fun getBusComing(callback: ApiCallBack<ListBusComingResponse>)
}