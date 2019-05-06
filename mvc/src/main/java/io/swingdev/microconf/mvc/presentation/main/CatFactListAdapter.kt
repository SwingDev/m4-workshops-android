package io.swingdev.microconf.mvc.presentation.main

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.swingdev.microconf.mvc.R
import io.swingdev.microconf.mvc.domain.model.CatFact
import io.swingdev.microconf.mvc.extensions.getLayoutInflater

class CatFactListAdapter : RecyclerView.Adapter<CatFactListAdapter.ItemViewHolder>() {
    private var _data = emptyList<CatFactItem>()
    var data = emptyList<CatFact>()
        set(value) {
            field = value
            _data = value.map(CatFact::toListItem)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        parent.getLayoutInflater()
            .inflate(R.layout.list_item_cat_fact, parent, false)
            .let { itemView ->
                ItemViewHolder(itemView)
            }

    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class ItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.factText)

        fun bind(item: CatFactItem) {
            title.text = item.text
        }
    }
}

data class CatFactItem(
    val text: String
)

private fun CatFact.toListItem() =
    CatFactItem(text)