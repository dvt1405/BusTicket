package kun.kt.busticket.util

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kun.kt.busticket.basedata.DataState
import retrofit2.HttpException

fun <T> MutableLiveData<DataState<T>>.onError(t: Throwable) {
    if (t is HttpException) {
        postValue(DataState.ApiError(t))
    } else {
        postValue(DataState.Error(t))
        Log.e("Error", t.message, t)
    }
}

fun <T> MutableLiveData<DataState<T>>.onSuccess(data: T) {
    postValue(DataState.Success(data))
}