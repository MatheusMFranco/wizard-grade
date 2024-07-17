package br.com.magalzim.adapters.http

import com.google.gson.annotations.SerializedName

data class WizardHttp(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("house") val house: String,
    @SerializedName("hogwartsStudent") val hogwartsStudent: Boolean,
)