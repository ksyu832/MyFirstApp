package ru.hramova.myfirstapp.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.hramova.myfirstapp.R
import android.widget.Toast
import ru.hramova.myfirstapp.databinding.CardPostBinding
import ru.hramova.myfirstapp.dto.Post
import ru.hramova.myfirstapp.dto.util.FormatUtils

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeClickListener: (Post) -> Unit,
    private val onShareClickListener: (Post) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            likeCount.text = FormatUtils.formatCount(post.likes)
            shareCount.text = FormatUtils.formatCount(post.shares)
            viewsCount.text = FormatUtils.formatCount(post.views)

           if (post.likedByMe) {
               like.setImageResource(R.drawable.ic_like_filled)
            } else {
            like.setImageResource(R.drawable.ic_like_border)}


            like.setOnClickListener {
                onLikeClickListener(post)
            }

            share.setOnClickListener {
                onShareClickListener(post)
            }

            menu.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "Меню поста ${post.id}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            avatar.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "Профиль автора ${post.author}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
