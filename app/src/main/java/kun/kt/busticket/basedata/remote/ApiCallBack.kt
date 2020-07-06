package kun.kt.busticket.basedata.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

abstract class ApiCallBack<T> : CommonCallBack<T> {
    val enqueueApi = object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(t)
        }

        override fun onResponse(
            call: Call<T>,
            response: Response<T>
        ) {
            onResponse(response)
        }

    }

    override fun onResponse(data: Response<T>) {
        when (data.code()) {
            in 200..299 -> {
                data.body()?.let {
                    onSuccess(it)
                    return
                }
                onError(HttpException(data))
            }
            else -> {
                onError(HttpException(data))
            }
        }
    }

    abstract fun onSuccess(t: T)
}