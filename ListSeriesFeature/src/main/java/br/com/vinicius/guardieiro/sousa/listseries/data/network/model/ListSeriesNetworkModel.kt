package br.com.vinicius.guardieiro.sousa.listseries.data.network.model


data class ListSeriesNetworkModel (
    val id: Long,
    val url: String,
    val name: String,
    val type: Type,
    val language: Language,
    val genres: List<String>,
    val status: Status,
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
    val image: Image?,
    val summary: String,
    val updated: Long,
    val _links: Links
)

data class Externals (
    val tvrage: Long,
    val thetvdb: Long? = null,
    val imdb: String? = null
)

data class Image (
    val medium: String,
    val original: String
)

enum class Language(val value: String) {
    English("English"),
    Japanese("Japanese");

    companion object {
        public fun fromValue(value: String): Language = when (value) {
            "English"  -> English
            "Japanese" -> Japanese
            else       -> throw IllegalArgumentException()
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
    val name: Name,
    val code: Code,
    val timezone: Timezone
)

enum class Code(val value: String) {
    CA("CA"),
    Fr("FR"),
    GB("GB"),
    Jp("JP"),
    Us("US");

    companion object {
        public fun fromValue(value: String): Code = when (value) {
            "CA" -> CA
            "FR" -> Fr
            "GB" -> GB
            "JP" -> Jp
            "US" -> Us
            else -> throw IllegalArgumentException()
        }
    }
}

enum class Name(val value: String) {
    Canada("Canada"),
    France("France"),
    Japan("Japan"),
    UnitedKingdom("United Kingdom"),
    UnitedStates("United States");

    companion object {
        public fun fromValue(value: String): Name = when (value) {
            "Canada"         -> Canada
            "France"         -> France
            "Japan"          -> Japan
            "United Kingdom" -> UnitedKingdom
            "United States"  -> UnitedStates
            else             -> throw IllegalArgumentException()
        }
    }
}

enum class Timezone(val value: String) {
    AmericaHalifax("America/Halifax"),
    AmericaNewYork("America/New_York"),
    AsiaTokyo("Asia/Tokyo"),
    EuropeLondon("Europe/London"),
    EuropeParis("Europe/Paris");

    companion object {
        public fun fromValue(value: String): Timezone = when (value) {
            "America/Halifax"  -> AmericaHalifax
            "America/New_York" -> AmericaNewYork
            "Asia/Tokyo"       -> AsiaTokyo
            "Europe/London"    -> EuropeLondon
            "Europe/Paris"     -> EuropeParis
            else               -> throw IllegalArgumentException()
        }
    }
}

data class Rating (
    val average: Double? = null
)

data class Schedule (
    val time: String,
    val days: List<Day>
)

enum class Day(val value: String) {
    Friday("Friday"),
    Monday("Monday"),
    Saturday("Saturday"),
    Sunday("Sunday"),
    Thursday("Thursday"),
    Tuesday("Tuesday"),
    Wednesday("Wednesday");

    companion object {
        public fun fromValue(value: String): Day = when (value) {
            "Friday"    -> Friday
            "Monday"    -> Monday
            "Saturday"  -> Saturday
            "Sunday"    -> Sunday
            "Thursday"  -> Thursday
            "Tuesday"   -> Tuesday
            "Wednesday" -> Wednesday
            else        -> throw IllegalArgumentException()
        }
    }
}

enum class Status(val value: String) {
    Ended("Ended"),
    Running("Running"),
    ToBeDetermined("To Be Determined");

    companion object {
        public fun fromValue(value: String): Status = when (value) {
            "Ended"            -> Ended
            "Running"          -> Running
            "To Be Determined" -> ToBeDetermined
            else               -> throw IllegalArgumentException()
        }
    }
}

enum class Type(val value: String) {
    Animation("Animation"),
    Documentary("Documentary"),
    News("News"),
    PanelShow("Panel Show"),
    Reality("Reality"),
    Scripted("Scripted"),
    Sports("Sports"),
    TalkShow("Talk Show"),
    Variety("Variety");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "Animation"   -> Animation
            "Documentary" -> Documentary
            "News"        -> News
            "Panel Show"  -> PanelShow
            "Reality"     -> Reality
            "Scripted"    -> Scripted
            "Sports"      -> Sports
            "Talk Show"   -> TalkShow
            "Variety"     -> Variety
            else          -> throw IllegalArgumentException()
        }
    }
}
