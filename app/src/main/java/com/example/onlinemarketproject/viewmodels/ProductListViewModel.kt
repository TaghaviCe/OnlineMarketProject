package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.CategoryRepository
import kotlinx.coroutines.launch

class ProductListViewModel:ViewModel() {
    var item= MutableLiveData<List<productItemX>>()
    var status= MutableLiveData<Status>()
    var sortClicked= MutableLiveData<Boolean>()


    fun getCategoryProductListItem(page:Int,categoryId:String) {
        val categoryRepository= CategoryRepository()
        viewModelScope.launch {
            status.value = Status.LOADING
            try {
                item.value =categoryRepository.getListItems(page , categoryId)
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                item.value= listOf()

            }
        }
    }
    fun sortIsClicked(){
        sortClicked.value=true
    }

}