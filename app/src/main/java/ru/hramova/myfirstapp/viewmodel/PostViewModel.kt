package ru.hramova.myfirstapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.hramova.myfirstapp.dto.Post
import ru.hramova.myfirstapp.repository.PostRepository
import ru.hramova.myfirstapp.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {

    init {
        println("ViewModel: created")
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel: cleared")
    }


    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data: LiveData<Post> = repository.get()

    fun like() = repository.like()
    fun share() = repository.share()
    fun increaseViews() = repository.increaseViews()
}
