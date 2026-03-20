package ru.hramova.myfirstapp.repository

import androidx.lifecycle.LiveData
import ru.hramova.myfirstapp.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>

    fun like()

    fun share()

    fun increaseViews()
}