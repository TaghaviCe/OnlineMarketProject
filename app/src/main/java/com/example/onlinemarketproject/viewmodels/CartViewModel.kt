package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.data.myPreference
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class CartViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var oneProduct= MutableLiveData<List<productItemX>>()


    fun getProdectListFromPreferenc(){

       var mylist=myPreference.getItem()
       val productRepository= ProductRepository()
    viewModelScope.launch {
        try {
            oneProduct.value = listOf(productRepository.getProductWithId(mylist.toInt()))
            status.value = Status.DONE

        } catch (e: Exception) {
            status.value = Status.ERROR
            oneProduct.value = listOf()

        }
    }
    }
}