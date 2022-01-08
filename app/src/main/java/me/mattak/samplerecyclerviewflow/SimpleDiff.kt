package me.mattak.samplerecyclerviewflow

import androidx.recyclerview.widget.DiffUtil

class SimpleDiff<T : Identity> : DiffUtil.ItemCallback<T>() {
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.identifier == newItem.identifier

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}
