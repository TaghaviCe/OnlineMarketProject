package com.example.onlinemarketproject.repositories


import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.network.ApiParameter
import com.example.onlinemarketproject.network.ShopApi
import retrofit2.Call

class ProductRepository() {
    suspend fun getAllItems():List<productItemX> {
       return ShopApi.retrofitService.listProductItems()
    }
    suspend fun getProductWithId( id:Int):productItemX{
        return ShopApi.retrofitService.getProductItem(Id=id)
    }

    suspend fun getPopularProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getPopularItems(par.getProduct_OPTION(
           par.POPULAR
        ))

    }

    suspend fun getRecentProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getPopularItems(par.getProduct_OPTION(
           par.RECENT
        ))

    }
    suspend fun geTopProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getPopularItems(par.getProduct_OPTION(
            par.TOP
        ))

    }


}