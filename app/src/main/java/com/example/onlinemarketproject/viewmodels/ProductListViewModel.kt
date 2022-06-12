package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarketproject.model.productItemX

class ProductListViewModel:ViewModel() {
    var item= MutableLiveData<List<productItemX>>()
}