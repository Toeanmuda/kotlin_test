package com.example.test_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.ArticlesItem2
import com.example.test_kotlin.databinding.ListItemBinding

class ListItemAdapterPaging(private val inItemClick: (ArticlesItem2) -> Unit) :
    PagingDataAdapter<ArticlesItem2, ListItemAdapterPaging.ListItemViewHolder>(DiffCallback)  {

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

        fun bind(result: ArticlesItem2) {
            bindin.apply {
                originalTitle.text = result.title
                overview.text = result.description
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ArticlesItem2>() {
            override fun areItemsTheSame(oldItem: ArticlesItem2, newItem: ArticlesItem2): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ArticlesItem2, newItem: ArticlesItem2): Boolean {
                return oldItem == newItem
            }

        }
    }
}