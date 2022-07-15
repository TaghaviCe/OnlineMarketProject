package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.data.myPreference
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class CartViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var oneProduct= arrayListOf<productItemX>()
    var productList=MutableLiveData<List<orderItem?>>()

//
//    fun getProdectListFromPreferenc(list:ArrayList<String>){
//
//      // var mylist:List<productItemX>? =myPreference.getCartProducts()
//    var productRepository=ProductRepository()
//    viewModelScope.launch {
//        try {
//           for (i in list){
//               oneProduct.add(productRepository.getProductWithId(i.toInt()))
//           }
//            productList.value=oneProduct
//            status.value = Status.DONE
//
//        } catch (e: Exception) {
//            status.value = Status.ERROR
//            productList.value= listOf()
//
//        }
//    }
//    }

    fun getListPref(orderItem: List<orderItem>){
        viewModelScope.launch {
            try{
                productList.value=orderItem
                status.value = Status.DONE

            }catch (e: Exception){
                status.value = Status.ERROR
                productList.value= listOf()

            }
        }


    }
}