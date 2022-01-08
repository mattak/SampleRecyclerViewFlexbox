package me.mattak.samplerecyclerviewflow

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import me.mattak.samplerecyclerviewflow.databinding.FragmentSampleBinding

class SampleFragment : Fragment(R.layout.fragment_sample) {
    companion object {
        fun newInstance() = SampleFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSampleBinding.bind(view)
        val adapter = SampleAdapter()
        val context = requireContext()
        val hDivider = createDivider(context, LinearLayoutManager.HORIZONTAL)
        val vDivider = createDivider(context, LinearLayoutManager.VERTICAL)

        binding.recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = FlexboxLayoutManager(requireContext()).apply {
                flexWrap = FlexWrap.WRAP
            }
            this.addItemDecoration(hDivider)
            this.addItemDecoration(vDivider)
        }

        val tags = (1..100).map { "Tag$it" }
        val items = tags.map(SampleViewHolder::Item)
        adapter.submitList(items)
    }

    private fun createDivider(context: Context, orientation: Int) =
        DividerItemDecoration(context, orientation).apply {
            ContextCompat.getDrawable(context, R.drawable.divider)
                ?.let(this::setDrawable)
        }
}
