package io.swingdev.microconf.advancedmvvm.presentation.main

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.swingdev.microconf.advancedmvvm.R
import io.swingdev.microconf.advancedmvvm.databinding.ListItemCatFactBinding
import io.swingdev.microconf.advancedmvvm.domain.model.CatFact
import io.swingdev.microconf.advancedmvvm.extensions.getLayoutInflater

class CatFactListAdapter : RecyclerView.Adapter<CatFactListAdapter.ItemViewHolder>() {
    private var _data = emptyList<CatFactItem>()
    var data = emptyList<CatFact>()
        set(value) {
            field = value
            _data = value.map(CatFact::toListItem)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                parent.getLayoutInflater(),
                R.layout.list_item_cat_fact,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class ItemViewHolder(
        private val binding: ListItemCatFactBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CatFactItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}

data class CatFactItem(
    val text: String
)

private fun CatFact.toListItem() =
    CatFactItem(text)