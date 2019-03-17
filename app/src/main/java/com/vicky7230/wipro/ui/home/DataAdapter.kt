package com.vicky7230.wipro.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.vicky7230.wipro.R
import com.vicky7230.wipro.data.network.model.Row
import com.vicky7230.wipro.utils.GlideApp
import kotlinx.android.synthetic.main.list_item.view.*

class DataAdapter(private val rows: MutableList<Row>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun clearItems() {
        this.rows?.clear()
        notifyDataSetChanged()
    }

    fun addItems(rows: MutableList<Row>?) {
        rows?.let { this.rows?.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return rows?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataViewHolder).onBind(rows?.get(position))
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(row: Row?) {
            GlideApp
                .with(itemView.context)
                .load(row?.imageHref)
                .error(R.drawable.error)
                .transition(withCrossFade())
                .centerCrop()
                .into(itemView.image)

            if (row?.title.isNullOrBlank())
                itemView.title.text = "N/A"
            else
                itemView.title.text = row?.title

            if (row?.description.isNullOrBlank())
                itemView.description.text = "N/A"
            else
                itemView.description.text = row?.description

        }
    }

}

