package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.searchfeature.databinding.RecyclerViewSearchItemBinding
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.model.SearchSeriesPresentationModel

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private var list : List<SearchSeriesPresentationModel> = listOf()

    var itemClickListener : ((Long) -> Unit)? = null

    fun addList(list : List<SearchSeriesPresentationModel>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = RecyclerViewSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position],itemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}