package me.mattak.samplerecyclerviewflow

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class SampleAdapter(
) : ListAdapter<SampleViewHolder.Item, SampleViewHolder>(SimpleDiff<SampleViewHolder.Item>()) {
    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder.create(parent.context)
    }
}
