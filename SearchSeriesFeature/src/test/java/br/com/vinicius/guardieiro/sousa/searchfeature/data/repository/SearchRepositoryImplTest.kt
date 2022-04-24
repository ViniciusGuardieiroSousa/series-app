package br.com.vinicius.guardieiro.sousa.searchfeature.data.repository

import br.com.vinicius.guardieiro.sousa.searchfeature.data.map.mockedSearchModelNetwork
import br.com.vinicius.guardieiro.sousa.searchfeature.data.map.toSearchSeriesData
import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.api.SearchApi
import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model.SearchModelNetwork
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepositoryImplTest {

    var api: SearchApi = mockk()

    private val listApi = mockk<List<SearchModelNetwork>>()


    private lateinit var repository: SearchRepositoryImpl

    @Before
    fun setup() {
        mockkStatic("br.com.vinicius.guardieiro.sousa.searchfeature.data.map.MapperKt")
        every { listApi.toSearchSeriesData() } returns mockk()
        coEvery { api.getSeriesByName(any()) } returns listApi
        repository = SearchRepositoryImpl(api)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `When call searchByName should  map to SearchSeriesData`() = runBlockingTest {
        repository.searchByName("name")
        coVerify(exactly = 1) { listApi.toSearchSeriesData() }
    }


}