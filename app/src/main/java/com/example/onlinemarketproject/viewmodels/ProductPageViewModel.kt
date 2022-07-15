package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductPageViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var oneProduct= MutableLiveData<productItemX>()

     fun getProductWithId(id : Int):productItemX?{
        val productRepository= ProductRepository()
        viewModelScope.launch {
            status.value = Status.LOADING
            try {
                oneProduct.value=productRepository.getProductWithId(id)
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR

            }
        }
         return oneProduct.value

    }

    fun getProductItem(): productItemX? {
        return oneProduct.value
    }
//    fun getProductItem(id: Int): productItemX? {
//        val productRepository= ProductRepository()
//        viewModelScope.launch {
//            status.value = Status.LOADING
//            try {
//                oneProduct.value=productRepository.getProductWithId(id)
//                status.value = Status.DONE
//
//            } catch (e: Exception) {
//                status.value=Status.ERROR
//
//            }
//        }
//        return oneProduct.value
//    }

}