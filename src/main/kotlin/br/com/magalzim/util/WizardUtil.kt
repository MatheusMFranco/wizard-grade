package br.com.magalzim.util

fun String.wizardID(isStudent: Boolean): String {
    val id = this.substring(0, 7)
    val wizardType = if (isStudent) "t" else "x"
    return "$wizardType$id"
}

fun String.house(): String {
    return when (this.lowercase()) {
        "gryffindor" -> "Grifinória"
        "hufflepuff" -> "Lufa-Lufa"
        "ravenclaw" -> "Corvinal"
        "slytherin" -> "Sonserina"
        else -> "Casa desconhecida"
    }
}

fun String.houseFromPortuguese(): String {
    val cleanedHouseName = this.lowercase()
        .replace("[^a-zA-Z]".toRegex(), "")
    return when (cleanedHouseName) {
        "grifinoria" -> "gryffindor"
        "lufalufa" -> "hufflepuff"
        "corvinal" -> "ravenclaw"
        "sonserina" -> "slytherin"
        else -> "Unknown House"
    }
}
