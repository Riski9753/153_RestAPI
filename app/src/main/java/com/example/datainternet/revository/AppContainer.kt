package com.example.datainternet.revository

import com.example.datainternet.service_Api.KontakService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val KontakRepository: KontakRepository
}

class KontakContainer : AppContainer{
    private val baseUrl = "https://kancadonor.net//donorg"
    private val json = Json {ignoreUnknownKey = true}
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val KontakService: KontakService by lezy{
        retrofit.create(KontakService::class.java)
    }
    override val KontakRepository: KontakRepository by lezy{
        NetworkKontakRepository(KontakService)
    }
}