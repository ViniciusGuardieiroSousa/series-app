package br.com.vinicius.guardieiro.sousa.listseries.presentation.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.listseries.databinding.RecyclerViewListItemBinding
import br.com.vinicius.guardieiro.sousa.listseries.presentation.model.ListSeriesPresentationModel
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview.ListSeriesViewHolder

class ListSeriesAdapter : RecyclerView.Adapter<ListSeriesViewHolder>() {

    private var list: List<ListSeriesPresentationModel> = listOf()

    var itemClickListener: ((Long) -> Unit)? = null

    fun addList(list: List<ListSeriesPresentationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSeriesViewHolder {
        val binding =
            RecyclerViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListSeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListSeriesViewHolder, position: Int) {
        holder.bind(list[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}