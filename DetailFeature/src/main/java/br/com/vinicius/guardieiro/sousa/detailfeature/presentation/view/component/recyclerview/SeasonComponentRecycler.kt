package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.component.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.ItemSeasonComponentBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.ItemSeasonsSeriesBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailEpisodePresentationModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.recyclerview.SeasonsSeriesViewHolder

class SeasonComponentAdapter : RecyclerView.Adapter<SeasonComponentViewHolder>() {

    var list: List<Long> = emptyList()
    var listener : (Long) -> Unit = {}

    fun addList(list: List<Long>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonComponentViewHolder {
        val binding =
            ItemSeasonComponentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonComponentViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: SeasonComponentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class SeasonComponentViewHolder(val binding: ItemSeasonComponentBinding, val listener : (Long) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Long) {
        binding.itemSeasonComponentText.text = item.toString()
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }
}
