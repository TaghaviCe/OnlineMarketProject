package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {


     var mCheapestItem=MutableLiveData<List<productItemX>>()
    var mExpensiveItem=MutableLiveData<List<productItemX>>()
   // private var itemListSelected= MutableLiveData<List<productItemX>>()
    var status= MutableLiveData<Status>()

    fun getCheapestItem(): List<productItemX>? {
        return mCheapestItem.value
    }
    fun getExpensiveItem(): List<productItemX>? {
        return mExpensiveItem.value
    }

    fun cheapestClicked(categoryId: String) {
        val productrepository= ProductRepository()
        viewModelScope.launch {
            try {
                mCheapestItem.value =productrepository.getCheapestProducts(20,categoryId)
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                mCheapestItem.value= listOf()

            }
        }
    }

    fun mostExpensiveClicked(categoryId: String) {
        val productrepository= ProductRepository()
        viewModelScope.launch {
            try {
                mExpensiveItem.value =productrepository.getCheapestProducts(20,categoryId)
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                mExpensiveItem.value= listOf()

            }
        }
    }



//    fun newestClicked() {
//        mRepository.fetchNewestProducts(mPerPage!!.value, mCategoryItemId!!.value)
//        dismissDialog.value = true
//    }
//
//    fun bestSellersClicked() {
//        mRepository.fetchBestSellersProducts(mPerPage!!.value, mCategoryItemId!!.value)
//        dismissDialog.value = true
//    }
}