package me.mattak.samplerecyclerviewflow

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import me.mattak.samplerecyclerviewflow.databinding.CellKeywordBinding

class SampleViewHolder(
    val binding: CellKeywordBinding,
) : RecyclerView.ViewHolder(binding.text) {
    companion object {
        fun create(context: Context) = SampleViewHolder(
            CellKeywordBinding.inflate(LayoutInflater.from(context))
        )
    }

    fun bind(item: Item) {
        binding.text.text = item.keyword
    }

    data class Item(val keyword: String) : Identity {
        override val identifier: String = keyword
    }
}
