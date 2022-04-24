package br.com.vinicius.guardieiro.sousa.searchfeature.data.map

import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class MapperKtTest {

    @Test
    fun `given a SearchModelNetwork when map should return the right value`() {

        val result = mockedSearchModelNetwork.toSearchSeriesData()


        assertEquals(mockedSearchModelNetwork.show.id, result.id)
        assertEquals(mockedSearchModelNetwork.show.name, result.name)
        assertEquals(mockedSearchModelNetwork.show.image?.original, result.image)
    }

    @Test
    fun `given a ListOf SearchModelNetwork when map should return the right value`() {

        val list = listOf(mockedSearchModelNetwork,mockedSearchModelNetwork,mockedSearchModelNetwork,mockedSearchModelNetwork,mockedSearchModelNetwork)

        val result = list.toSearchSeriesData()
        list.forEachIndexed { index, searchModelNetwork ->
            assertEquals(searchModelNetwork.show.id, result[index].id)
            assertEquals(searchModelNetwork.show.name, result[index].name)
            assertEquals(searchModelNetwork.show.image?.original, result[index].image)
        }
    }

}

val mockedCountry = Country(
    name = "name",
    code = "code",
    timezone = "timezone"
)


val mockedNetwork = Network(
    id = Random.nextLong(),
    name = "name",
    country = mockedCountry,
    officialSite = "officialSite",
)

val mockedRating = Rating(
    average = Random.nextDouble()
)

val mockedSchedule = Schedule(
    time = "time",
    days = listOf("day1", "day2")
)

val mockedExternals = Externals(
    tvrage = Random.nextLong(),
    thetvdb = Random.nextLong(),
    imdb = "imdb"
)

val mockedImage = Image(
    original = "original",
    medium = "medium"
)

val mockedNextEpisode = NextEpisode(
    "href"
)

val mockedLinks = Links(
    self = mockedNextEpisode,
    previousepisode = mockedNextEpisode,
    nextepisode = mockedNextEpisode,
)

val mockedShow = Show(
    id = Random.nextLong(),
    url = "url",
    name = "name",
    type = "type",
    language = "language",
    genres = listOf("genre1", "genre2"),
    status = "status",
    runtime = Random.nextLong(),
    averageRuntime = Random.nextLong(),
    premiered = "premiered",
    ended = "ended",
    officialSite = "officialSite",
    schedule = mockedSchedule,
    rating = mockedRating,
    weight = Random.nextLong(),
    network = mockedNetwork,
    webChannel = mockedNetwork,
    dvdCountry = null,
    externals = mockedExternals,
    image = mockedImage,
    summary = "summary",
    updated = Random.nextLong(),
    _links = mockedLinks
)

val mockedSearchModelNetwork = SearchModelNetwork(
    score = Random.nextDouble(),
    show = mockedShow
)