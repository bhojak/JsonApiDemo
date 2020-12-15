package com.bhupen.jsonapidemo.utils

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bhupen.jsonapidemo.domain.model.Post
import com.bhupen.jsonapidemo.domain.model.User
import com.bhupen.jsonapidemo.ui.main.MainAdapter
import com.bhupen.jsonapidemo.ui.post.PostAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    val adapter = recyclerView.adapter as MainAdapter
    data?.let {
        adapter.submitList(data.toMutableList())
        recyclerView.smoothSnapToPosition(0)
    }

}

@BindingAdapter("listData")
fun bindRecyclerViewPost(recyclerView: RecyclerView, data: List<Post>?) {
    val adapter = recyclerView.adapter as PostAdapter
    data?.let {
        adapter.submitList(data.toMutableList())
    }
}

@BindingAdapter("isVisible")
fun bindProgressBarView(progressBar: ProgressBar, visible:Boolean) {
    progressBar.isVisible = visible
}