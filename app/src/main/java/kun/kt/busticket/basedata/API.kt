package kun.kt.busticket.basedata

import kun.kt.busticket.basedata.entities.ListBusComingResponse
import kun.kt.busticket.basedata.entities.ListBusNumberResponse
import kun.kt.busticket.basedata.entities.ListCityResponse
import kun.kt.busticket.basedata.entities.customer.Customer
import kun.kt.busticket.basedata.entities.customer.request.PhoneRequest
import kun.kt.busticket.basedata.entities.customer.request.RegisterCustomerRequest
import kun.kt.busticket.basedata.entities.customer.response.RegisterCustomerResponse
import kun.kt.busticket.basedata.entities.ticket.request.BuyTicketRequest
import kun.kt.busticket.basedata.entities.ticket.request.ExtendTicketRequest
import kun.kt.busticket.basedata.entities.ticket.response.BusTicketTypeResponse
import kun.kt.busticket.basedata.entities.ticket.response.BuyTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ExtendTicketResponse
import kun.kt.busticket.basedata.entities.ticket.response.ListTicketResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("getBusNumber")
    fun getBusNumber(): Call<ListBusNumberResponse>

    @GET("getBusComing")
    fun getBusComing(): Call<ListBusComingResponse>

    @POST("getCustomer")
    fun getCustomer(@Body phone: PhoneRequest): Call<Customer>

    @POST("register")
    fun register(@Body registerCustomerRequest: RegisterCustomerRequest): Call<RegisterCustomerResponse>

    @POST("buyTicket")
    fun buyTicket(@Body buyTicketRequest: BuyTicketRequest): Call<BuyTicketResponse>

    @POST("getTicket")
    fun getTicket(@Body phone: PhoneRequest): Call<ListTicketResponse>

    @GET("extendTicket")
    fun extendTicket(@Body extendTicketRequest: ExtendTicketRequest): Call<ExtendTicketResponse>

    @GET("getCities")
    fun getCities(): Call<ListCityResponse>

    @GET("getBusTicketType")
    fun getBusTicketType(): Call<BusTicketTypeResponse>

    @Multipart
    @POST("https://vnest.vn/bus-sdk-upload")
    fun uploadImage(@Part image: MultipartBody.Part)
}