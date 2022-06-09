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
    var listPopular=MutableLiveData<List<productItemX>>()
   var listReacent=MutableLiveData<List<productItemX>>()
   var listTop=MutableLiveData<List<productItemX>>()

    init {
        getProductItem()
        getPopularList()
        getRecentList()
        getTopList()
    }

   fun getProductItem() {
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
    }

    fun getPopularList(){
        val productRepository=ProductRepository()
        viewModelScope.launch{
            status.value = Status.LOADING
            try {
                listPopular.value =productRepository.getPopularProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
               listPopular.value= listOf()

            }
        }
    }

    fun getRecentList(){
        val productRepository=ProductRepository()
        viewModelScope.launch{
            status.value = Status.LOADING
            try {
                listReacent.value =productRepository.getRecentProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                listReacent.value= listOf()

            }
        }
    }

    fun getTopList(){
        val productRepository=ProductRepository()
        viewModelScope.launch{
            status.value = Status.LOADING
            try {
                listTop.value =productRepository.geTopProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
               listTop.value= listOf()

            }
        }
    }
}