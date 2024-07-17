package br.com.magalzim.domain.model

import java.io.Serializable

data class Wizard(
    val id: String,
    val name: String,
    val house: String,
    val isStudent: Boolean? = null
) : Serializable
