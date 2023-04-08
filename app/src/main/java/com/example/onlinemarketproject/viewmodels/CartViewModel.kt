package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.data.myPreference
import com.example.onlinemarketproject.model.LineItems
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class CartViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var oneProduct= MutableLiveData<productItemX>()
    var productList=MutableLiveData<List<LineItems?>>()
    var totalPrice= MutableLiveData<Double>(0.0)


    fun getListPref(orderItem: List<LineItems>){
        viewModelScope.launch {
            try{
                productList.value=orderItem
                status.value = Status.DONE
                var sum=0.0
                for(i in orderItem){
                    sum+=i.pricePerItem
                }
                totalPrice.value=sum

            }catch (e: Exception){
                status.value = Status.ERROR
                productList.value= listOf()

            }
        }

    }



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
}