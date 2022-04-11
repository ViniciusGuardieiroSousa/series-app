package br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model


data class SearchModelNetwork (
    val score: Double,
    val show: Show
)

data class Show (
    val id: Long,
    val url: String,
    val name: String,
    val type: Type,
    val language: Language,
    val genres: List<String>,
    val status: String,
    val runtime: Long? = null,
    val averageRuntime: Long? = null,
    val premiered: String? = null,
    val ended: String? = null,
    val officialSite: String? = null,
    val schedule: Schedule,
    val rating: Rating,
    val weight: Long,
    val network: Network? = null,
    val webChannel: Network? = null,
    val dvdCountry: Any? = null,
    val externals: Externals,
    val image: Image? = null,
    val summary: String? = null,
    val updated: Long,
    val _links: Links
)

data class Externals (
    val tvrage: Long? = null,
    val thetvdb: Long? = null,
    val imdb: String? = null
)

data class Image (
    val medium: String,
    val original: String
)

enum class Language(val value: String) {
    English("English"),
    Mongolian("Mongolian");

    companion object {
        public fun fromValue(value: String): Language = when (value) {
            "English"   -> English
            "Mongolian" -> Mongolian
            else        -> throw IllegalArgumentException()
        }
    }
}

data class Links (
    val self: Nextepisode,
    val previousepisode: Nextepisode? = null,
    val nextepisode: Nextepisode? = null
)

data class Nextepisode (
    val href: String
)

data class Network (
    val id: Long,
    val name: String,
    val country: Country? = null,
    val officialSite: String? = null
)

data class Country (
    val name: String,
    val code: String,
    val timezone: String
)

data class Rating (
    val average: Double? = null
)

data class Schedule (
    val time: String,
    val days: List<String>
)

enum class Type(val value: String) {
    Documentary("Documentary"),
    Scripted("Scripted");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "Documentary" -> Documentary
            "Scripted"    -> Scripted
            else          -> throw IllegalArgumentException()
        }
    }
}

