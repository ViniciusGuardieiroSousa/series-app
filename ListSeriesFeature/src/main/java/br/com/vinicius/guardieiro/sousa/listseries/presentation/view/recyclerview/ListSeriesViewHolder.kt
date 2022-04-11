package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.ImageDownloader
import br.com.vinicius.guardieiro.sousa.listseries.databinding.RecyclerViewListItemBinding
import br.com.vinicius.guardieiro.sousa.listseries.presentation.model.ListSeriesPresentationModel

class ListSeriesViewHolder(private val binding: RecyclerViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: ListSeriesPresentationModel,
        itemClickListener: ((Long) -> Unit)?,
    ) {
        binding.searchSeriesName.text = item.name
        binding.root.setOnClickListener {
            itemClickListener?.invoke(item.id)
        }
        binding.searchSeriesProgress.visibility = View.VISIBLE
        binding.searchSeriesImage.visibility = View.GONE
        item.image?.let{
            ImageDownloader.downloadImage(binding.root.context, it){
                binding.searchSeriesImage.setImageBitmap(it)
                binding.searchSeriesProgress.visibility = View.GONE
                binding.searchSeriesImage.visibility = View.VISIBLE
            }
        }
    }
}