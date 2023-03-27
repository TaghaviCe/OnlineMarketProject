package com.example.onlinemarketproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    var status= MutableLiveData<Status>()
    var item=MutableLiveData<List<productItemX>>()
    var listElectronic=MutableLiveData<List<productItemX>>()
    var listReacent=MutableLiveData<List<productItemX>>()
    var listMen=MutableLiveData<List<productItemX>>()
    var listWoman=MutableLiveData<List<productItemX>>()


    init {
        getProductItem()
        getElectronicList()
        getRecentList()
        getMenList()
        getWomanList()
    }

    fun getWomanList() {
        val productRepository=ProductRepository()
        viewModelScope.launch {
            status.value = Status.LOADING
            try {
                listWoman.value =productRepository.geWomanProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                listWoman.value= listOf()

            }
        }
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

    fun getElectronicList(){
        val productRepository=ProductRepository()
        viewModelScope.launch{
            status.value = Status.LOADING
            try {
                listElectronic.value =productRepository.getElectronicsProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                listElectronic.value= listOf()

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

    fun getMenList(){
        val productRepository=ProductRepository()
        viewModelScope.launch{
            status.value = Status.LOADING
            try {
                listMen.value =productRepository.getMenProduct()
                status.value = Status.DONE

            } catch (e: Exception) {
                status.value=Status.ERROR
                listMen.value= listOf()

            }
        }
    }
}