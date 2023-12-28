package com.example.datainternet.revository

import com.example.datainternet.Model.Kontak
import com.example.datainternet.service_Api.KontakService

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
}
class NetworkKontakRepository(
    private val KontakApiService: KontakService
) : KontakRepository {
    override suspend fun getKontak(): List<Kontak> {
        TODO("Not yet implemented")
    }
}