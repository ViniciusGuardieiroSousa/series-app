package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.ImageDownloader
import br.com.vinicius.guardieiro.sousa.detailfeature.R
import br.com.vinicius.guardieiro.sousa.detailfeature.di.detailModules
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.ActivityDetailSeriesBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailEpisodePresentationModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailSeriesPresentationModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.recyclerview.SeasonsSeriesAdapter
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.viewModel.DetailSeriesViewModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.viewModel.EitherPresentationModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

const val ID_EXTRA = "id_extra"

class DetailSeriesActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, id: Long): Intent {
            val intent= Intent("detail.activity")
            intent.putExtra(ID_EXTRA, id)
            return intent
        }
    }

    private lateinit var adapter: SeasonsSeriesAdapter
    private val binding by lazy {
        ActivityDetailSeriesBinding.inflate(layoutInflater)
    }

    val viewModel: DetailSeriesViewModel by viewModel()

    init {
        loadKoinModules(listOf(detailModules))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpRecyclerView()
        setUpObserver()
        setUpSpinner()
        setUpLoadObserver()
        viewModel.getDetail(intent.getLongExtra(ID_EXTRA, 1))
    }

    private fun setUpRecyclerView() {
        binding.detailSeasons.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = SeasonsSeriesAdapter()
        binding.detailSeasons.adapter = adapter
        binding.detailSeasons.isNestedScrollingEnabled = false
    }

    private fun setUpSpinner() {
        binding.detailSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (viewModel.series.value is EitherPresentationModel.Right) {
                    val value = (viewModel.series.value as EitherPresentationModel.Right).value
                    val season = value?.episodes?.keys?.toList()?.get(p2)
                    val listEpisodes = value?.episodes?.get(season)
                    listEpisodes?.let {
                        adapter.addList(it)
                    }
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun setUpLoadObserver() {
        viewModel.loadState.observe(this) {
            if (it) {
                binding.detailContainer.visibility = View.GONE
                binding.detailProgress.visibility = View.VISIBLE
            } else {
                binding.detailContainer.visibility = View.VISIBLE
                binding.detailProgress.visibility = View.GONE
            }
        }
    }

    private fun setUpObserver() {
        viewModel.series.observe(this) {
            when (it) {
                is EitherPresentationModel.Right -> {
                    val value = it.value
                    configSpinner(
                        value.episodes.keys.toList(),
                        value.episodes[value.episodes.keys.first()]
                    )
                    configPoster(value.image)
                    configFavorite(value.isFavorite)
                    configText(value)
                }
                else -> {
                    Toast.makeText(
                        applicationContext,
                        "For some reason we couldn't get more details about the series",
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                }
            }

        }
    }

    private fun configText(item: DetailSeriesPresentationModel) {
        binding.detailTitle.text = item.name
        binding.detailTimeInAir.text =
            "First episode in air: ${item.firstEpisodeDate}, last episode in air  ${item.lastEpisodeDate}, ${item.timeInAir} in air"
        binding.detailSummary.text = item.summary
        binding.detailGenres.text = "Genres: ${item.genres.joinToString(", ")}"
    }

    private fun configSpinner(
        itemSeasonsList: List<Long>,
        firstSeasonEpisodes: List<DetailEpisodePresentationModel>?
    ) {
        val spinnerAdapter: ArrayAdapter<Long> = ArrayAdapter<Long>(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            itemSeasonsList
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.detailSpinner.adapter = spinnerAdapter
        firstSeasonEpisodes?.let {
            adapter.addList(it)
        }
    }

    private fun configPoster(imageUrl: String?) {
        imageUrl?.let {
            ImageDownloader.downloadImage(this, it) {
                binding.detailPoster.setImageBitmap(it)
            }
        }
    }

    private fun configFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            binding.detailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            binding.detailFavorite.setOnClickListener {
                viewModel.removeFavorite()
                configFavorite(false)
            }
        } else {
            binding.detailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            binding.detailFavorite.setOnClickListener {
                viewModel.addFavorite()
                configFavorite(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(detailModules))
    }
}