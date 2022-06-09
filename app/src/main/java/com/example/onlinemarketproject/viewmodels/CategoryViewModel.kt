package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.Category
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.CategoryRepository
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var item= MutableLiveData<List<Category>>()

    init {
        getCategoryItem()
    }


    fun getCategoryItem() {
        val categoryRepository= CategoryRepository()
        viewModelScope.launch {
            status.value = Status.LOADING
            try {
                item.value =categoryRepository.getAllItems()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                item.value= listOf()

            }
        }
    }

}