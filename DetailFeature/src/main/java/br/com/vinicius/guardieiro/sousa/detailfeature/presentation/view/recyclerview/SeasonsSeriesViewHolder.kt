package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.ItemSeasonsSeriesBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailEpisodePresentationModel

class SeasonsSeriesViewHolder(private val binding: ItemSeasonsSeriesBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item:  DetailEpisodePresentationModel
    ) {
        binding.episodeName.text = "Episode ${item.number.toString()}: ${item.name.toString()}"
        binding.episodeSummary.text = item.summary
        binding.episodeAirDate.text = item.airDate
    }
}