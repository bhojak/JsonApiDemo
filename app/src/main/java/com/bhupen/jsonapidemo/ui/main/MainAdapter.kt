package com.bhupen.jsonapidemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhupen.jsonapidemo.databinding.UserListItemBinding
import com.bhupen.jsonapidemo.domain.model.User


class MainAdapter(val itemClick:(User)-> Unit) : androidx.recyclerview.widget.ListAdapter<User, MainAdapter.ViewHolder>(MainDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    inner class ViewHolder(private var binding: UserListItemBinding, var itemClick:(User)-> Unit) : RecyclerView.ViewHolder(binding.root){
        fun bindTo(user: User){
            binding.property = user
            binding.executePendingBindings()
        }
    }

}




class MainDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}

