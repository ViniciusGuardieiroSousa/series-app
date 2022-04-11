package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.ImageDownloader
import br.com.vinicius.guardieiro.sousa.searchfeature.databinding.RecyclerViewSearchItemBinding
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.model.SearchSeriesPresentationModel

class SearchViewHolder(private val binding: RecyclerViewSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: SearchSeriesPresentationModel,
        itemClickListener: ((Long) -> Unit)?,
    ) {
        binding.searchSeriesName.text = item.name
        binding.root.setOnClickListener {
            itemClickListener?.invoke(item.id)
        }
        binding.searchSeriesProgress.visibility = View.VISIBLE
        binding.searchSeriesImage.visibility = View.GONE
        item.image?.let{
            ImageDownloader.downloadImage(binding.root.context, item.image){
                binding.searchSeriesImage.setImageBitmap(it)
                binding.searchSeriesProgress.visibility = View.GONE
                binding.searchSeriesImage.visibility = View.VISIBLE
            }
        }
    }
}