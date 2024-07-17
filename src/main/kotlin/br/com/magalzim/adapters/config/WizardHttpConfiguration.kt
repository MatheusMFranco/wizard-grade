package br.com.magalzim.adapters.config

import br.com.magalzim.adapters.http.WizardHttpService
import io.github.resilience4j.retrofit.CircuitBreakerCallAdapter
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class WizardHttpConfiguration(
    private val circuitBreakerConfiguration: CircuitBreakerConfiguration
) {

    private companion object {
        const val BASE_URL = "https://hp-api.herokuapp.com"
    }

    private fun buildClient() = OkHttpClient.Builder().build()

    private fun buildRetrofit() = Retrofit.Builder()
        .addCallAdapterFactory(CircuitBreakerCallAdapter.of(circuitBreakerConfiguration.getCircuitBreaker()))
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildClient())
        .build()

    @Bean
    fun studentHttpService(): WizardHttpService = buildRetrofit().create(WizardHttpService::class.java)
}