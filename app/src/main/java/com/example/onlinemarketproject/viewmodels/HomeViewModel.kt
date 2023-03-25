package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch


enum class Status{LOADING,DONE,ERROR}

class HomeViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var item=MutableLiveData<List<productItemX>>()

    init {
        getProductItem()
    }


    fun getProductItem(): List<productItemX>? {
        val productRepository=ProductRepository()
        viewModelScope.launch {
            status.value = Status.LOADING
            try {
                item.value =productRepository.getAllItems()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                item.value= listOf()

            }
        }
        return item.value
    }

    fun getSearchList(productItemX: List<productItemX>){
            item.value=productItemX
    }


}