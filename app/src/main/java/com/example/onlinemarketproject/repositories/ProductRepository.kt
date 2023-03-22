package com.example.onlinemarketproject.repositories


import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.network.ApiParameter
import com.example.onlinemarketproject.network.ApiService
import com.example.onlinemarketproject.network.ShopApi
import retrofit2.Call

class ProductRepository() {
    suspend fun getAllItems():List<productItemX> {
       return ShopApi.retrofitService.listProductItems()
    }
    suspend fun getProductWithId( id:Int):productItemX{
        return ShopApi.retrofitService.getProductItem(Id=id)
    }

    suspend fun getRecentProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getCategoryProducts(par.POPULAR

        )

    }

    suspend fun getPopularProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getCategoryProducts(
           par.electronics
        )

    }
    suspend fun geTopProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getCategoryProducts(
            par.MEN
        )

    }

    suspend fun geWomanProduct():List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getCategoryProducts(
            par.WOMAN
        )

    }



    suspend fun getCategoryOption(page:Int,categoryId:String):List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.getProductsOfCategory(
            par.getCategory_Items(page,categoryId)
        )

    }

    suspend fun getSearchItem(query:String,categoryId:String):List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.listProductItems(
            par.getSearchOption(query,categoryId)
        )
    }


    suspend fun getCheapestProducts(page:Int,categoryId:String):List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.listProductItems(
            par.getCheapestOption(page,categoryId)
        )

    }

    suspend fun getExpensiveProducts(page:Int,categoryId: String):List<productItemX>{
        var par=ApiParameter()
        return ShopApi.retrofitService.listProductItems(
            par.getExpensiveOption(page,categoryId)
        )
    }

}