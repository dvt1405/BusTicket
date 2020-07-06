package kun.kt.busticket.basedata

import retrofit2.HttpException

sealed class DataState<T> {
    data class Success<T>(val value: T) : DataState<T>()
    data class LocalSuccess<T>(val value: T) : DataState<T>()
    data class RemoteSuccess<T>(val value: T) : DataState<T>()
    data class Error<T>(val throwable: Throwable?) : DataState<T>()
    data class ApiError<T>(val throwable: HttpException?) : DataState<T>()
    class Loading<T> : DataState<T>()
    class Succeeded<T> : DataState<T>()
}