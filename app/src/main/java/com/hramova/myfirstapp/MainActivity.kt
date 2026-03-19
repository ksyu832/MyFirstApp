package ru.hramova.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.hramova.myfirstapp.databinding.ActivityMainBinding
import ru.hramova.myfirstapp.dto.Post
import ru.hramova.myfirstapp.dto.util.FormatUtils



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        post = Post(
            id = 1,
            author = getString(R.string.text_author),
            content = getString(R.string.text_content),
            published = getString(R.string.date),
            likedByMe = false,
            likes = 999,
            shares = 25,
            views = 5700
        )

        bindPost(post)

        setupClickListeners()
    }

    private fun bindPost(post: Post) {
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
                like.setImageResource(R.drawable.ic_like_border)
            }

            linkTitle.text = getString(R.string.text_link)
            linkUrl.text = getString(R.string.netology_ru)
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            like.setOnClickListener {
                post = post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )

                bindPost(post)

                Toast.makeText(this@MainActivity,
                    if (post.likedByMe) "Лайк поставлен" else "Лайк убран",
                    Toast.LENGTH_SHORT).show()
            }

            share.setOnClickListener {
                println("CLICK: репост layout")
                post = post.copy(
                    shares = post.shares + 1
                )

                bindPost(post)

                Toast.makeText(this@MainActivity, "Репост +1", Toast.LENGTH_SHORT).show()
            }

            menu.setOnClickListener {
                println("CLICK: меню layout")
                Toast.makeText(this@MainActivity, "Меню поста", Toast.LENGTH_SHORT).show()
            }

            avatar.setOnClickListener {

                Toast.makeText(this@MainActivity, "Профиль автора", Toast.LENGTH_SHORT).show()

            }

            root.setOnClickListener {
                println("CLICK: корневой layout")
                Toast.makeText(this@MainActivity, "Клик по фону", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
