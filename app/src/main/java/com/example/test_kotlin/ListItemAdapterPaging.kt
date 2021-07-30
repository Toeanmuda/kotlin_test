package com.example.test_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.ArticlesItem
import com.example.test_kotlin.databinding.ListItemBinding

class ListItemAdapterPaging(private val inItemClick: (ArticlesItem) -> Unit) :
    PagingDataAdapter<ArticlesItem, ListItemAdapterPaging.ListItemViewHolder>(DiffCallback)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val value = getItem(position)
        holder.itemView.setOnClickListener {
            if (value != null) {
                inItemClick(value)
            }
        }
        if (value != null) {
            holder.bind(value)
        }
    }


    class ListItemViewHolder(private var bindin: ListItemBinding) :
        RecyclerView.ViewHolder(bindin.root) {

        fun bind(result: ArticlesItem) {
            bindin.apply {
                originalTitle.text = result.title
                overview.text = result.description
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}