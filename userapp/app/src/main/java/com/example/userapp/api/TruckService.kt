package com.example.userapp.api
import com.example.userapp.models.total_products
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

 const val BASE_URL="http://192.168.29.84:3000/"

interface TruckService {

    @FormUrlEncoded
    @POST("products")
    fun postProduct(
        @Field("email") email:String,
        @Field("name") name:String,
        @Field("password") password:String,
        @Field("school") school:String
    )
    :Call<total_products>

    @GET("products")
     fun getProducts(

     ):Call<total_products>


}


object RetrofitClient {

    private val okHttpClient= OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original=chain.request()

                val requestBuilder=original.newBuilder()
                        .addHeader("Accept","application/json")
                        .method(original.method, original.body)

                val request=requestBuilder.build()
                chain.proceed(request)
            }.build()

    val instance: TruckService by lazy {
        val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()


        retrofit.create(TruckService::class.java)
    }
}