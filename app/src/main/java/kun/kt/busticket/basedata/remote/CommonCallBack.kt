package kun.kt.busticket.basedata.remote

import retrofit2.Response

interface CommonCallBack <T> {
    fun onResponse(data: Response<T>)
    fun onError(throwable: Throwable)
}