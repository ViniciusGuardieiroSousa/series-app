package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.databinding.RecyclerViewListItemBinding
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.model.FavoritePresentationModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.recyclerview.FavoriteViewHolder

class FavoriteAdapter : RecyclerView.Adapter<FavoriteViewHolder>() {

    private var list : List<FavoritePresentationModel> = listOf()

    var itemClickListener : ((Long) -> Unit)? = null

    fun addList(list : List<FavoritePresentationModel>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = RecyclerViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(list[position],itemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}