package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.ItemSeasonsSeriesBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailEpisodePresentationModel

class SeasonsSeriesAdapter : RecyclerView.Adapter<SeasonsSeriesViewHolder>() {

    private var list : List<DetailEpisodePresentationModel> = listOf()


    fun addList(list :  List<DetailEpisodePresentationModel>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonsSeriesViewHolder {
        val binding = ItemSeasonsSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonsSeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeasonsSeriesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}