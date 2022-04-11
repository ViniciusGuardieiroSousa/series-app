package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.ImageDownloader
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.databinding.RecyclerViewListItemBinding
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.model.FavoritePresentationModel

class FavoriteViewHolder(private val binding: RecyclerViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: FavoritePresentationModel,
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