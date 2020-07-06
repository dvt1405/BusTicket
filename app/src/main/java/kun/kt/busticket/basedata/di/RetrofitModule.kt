package kun.kt.busticket.basedata.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kun.kt.busticket.basedata.API
import kun.kt.busticket.basedata.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tun.kt.apilib.apihistory.CustomInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun providesInterceptor(): CustomInterceptor {
        val interceptor = CustomInterceptor()
        interceptor.level = CustomInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun providesGsonConverter() = GsonConverterFactory.create(GsonBuilder().create())

    @Provides
    @Singleton
    fun providesClient(interceptor: CustomInterceptor): OkHttpClient.Builder = OkHttpClient.Builder()
        .connectTimeout(Constant.CONNECT_TIME_OUT,TimeUnit.MINUTES)
        .readTimeout(Constant.READ_TIME_OUT,TimeUnit.SECONDS)
        .writeTimeout(Constant.WRITE_TIME_OUT,TimeUnit.SECONDS)
        .addInterceptor(interceptor)



    @Provides
    @Singleton
    fun providesApi(gsonConverterFactory: GsonConverterFactory,client: OkHttpClient.Builder): API = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .baseUrl(Constant.URL)
        .client(client.build())
        .build()
        .create(API::class.java)
}