package io.swingdev.microconf.mvvm.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewBindings {

    @JvmStatic
    @BindingAdapter("adapter")
    fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
        this.adapter = adapter
    }
}