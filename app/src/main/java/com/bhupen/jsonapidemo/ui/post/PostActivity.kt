package com.bhupen.jsonapidemo.ui.post

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bhupen.jsonapidemo.R
import com.bhupen.jsonapidemo.databinding.ActivityPostBinding
import com.bhupen.jsonapidemo.utils.NavargId

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostActivity : AppCompatActivity(){
    private lateinit var binding: ActivityPostBinding
    private val viewModel :PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = PostAdapter{

        }
        binding.recyclerViewPostsResults.adapter = adapter
        val id = intent.getIntExtra(NavargId.userId.name, 1)
        viewModel.fetchUserWithPosts(id)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewModel.error.observe(this,{
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}