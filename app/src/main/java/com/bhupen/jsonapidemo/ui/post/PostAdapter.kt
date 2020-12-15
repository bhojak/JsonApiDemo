package com.bhupen.jsonapidemo.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bhupen.jsonapidemo.databinding.PostListItemBinding
import com.bhupen.jsonapidemo.domain.model.Post


class PostAdapter(val itemClick:(Post)-> Unit) : ListAdapter<Post, PostAdapter.ViewHolder>(PostDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    inner class ViewHolder(private var binding: PostListItemBinding, var itemClick:(Post)-> Unit) : RecyclerView.ViewHolder(binding.root){
        fun bindTo(post: Post){
            binding.property = post
            binding.executePendingBindings()
        }
    }

}




class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}