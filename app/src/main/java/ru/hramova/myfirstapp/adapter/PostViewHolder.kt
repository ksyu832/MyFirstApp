package ru.hramova.myfirstapp.adapter

import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.hramova.myfirstapp.R
import ru.hramova.myfirstapp.databinding.CardPostBinding
import ru.hramova.myfirstapp.dto.Post
import ru.hramova.myfirstapp.dto.util.FormatUtils
import java.text.DecimalFormat

class PostViewHolder(
    private val binding: CardPostBinding,
    private val listener: OnPostInteractionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            likeCount.text = FormatUtils.formatCount(post.likes)
            shareCount.text = FormatUtils.formatCount(post.shares)
            viewsCount.text = FormatUtils.formatCount(post.views)

            like.setImageResource(
                if (post.likedByMe) R.drawable.ic_like_filled
                else R.drawable.ic_like_border
            )

            like.setOnClickListener {
                listener.onLike(post)
            }

            share.setOnClickListener {
                listener.onShare(post)
            }

            avatar.setOnClickListener {
                listener.onAvatarClick(post)
            }

            menu.setOnClickListener { view ->
                showPopupMenu(view, post)
            }
        }
    }

    private fun showPopupMenu(anchor: View, post: Post) {
        PopupMenu(anchor.context, anchor).apply {
            inflate(R.menu.post_menu)

            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.edit -> {
                        listener.onEdit(post)
                        true
                    }
                    R.id.remove -> {
                        listener.onRemove(post)
                        true
                    }
                    else -> false
                }
            }
            show()
        }
    }

}
