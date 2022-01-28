package com.example.chucknorrisapp

import android.util.Log
import androidx.lifecycle.*
import com.example.chucknorrisapp.network.data.ChuckNorrisRsponse
import com.example.chucknorrisapp.repository.MainRepository
import kotlinx.coroutines.launch

class JokesViewModel(private val repository: MainRepository) : ViewModel() {

    private val _joke = MutableLiveData<ChuckNorrisRsponse>()
    val joke:LiveData<ChuckNorrisRsponse> get() = _joke

    fun randomJokes() {
        viewModelScope.launch {
            val response = repository.randomJokes()
            if(response.isSuccessful){
                _joke.postValue(response.body())
            }else{
                Log.d("fetch","error in loading joke")
            }
        }
    }

    fun jokesCategories(){
        viewModelScope.launch {
            val response = repository.jokesCategories()
            if(response.isSuccessful){
                val data = response.body()
                Log.d("fetch", "categories: ${data}")
            }else{
                Log.d("fetch","error in loading jokesCategories")
            }
        }
    }

}

class JokesViewModelFactory(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokesViewModel::class.java)) {

            return JokesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}