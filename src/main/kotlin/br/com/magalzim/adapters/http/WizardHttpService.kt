package br.com.magalzim.adapters.http

import org.springframework.stereotype.Service
import retrofit2.http.GET
import retrofit2.http.Path

@Service
interface WizardHttpService {

    @GET("api/characters/house/{house}")
    suspend fun getByHouse(@Path("house") house: String): List<WizardHttp>
}