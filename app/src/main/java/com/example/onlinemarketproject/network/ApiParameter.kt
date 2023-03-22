package com.example.onlinemarketproject.network

class ApiParameter {
    val BASE_URL = "https://fakestoreapi.com/"

    val POPULAR = "jewelery"
    val electronics = "electronics"
    val MEN = "men's clothing"
    val WOMAN = "women's clothing"
    val ORDERBY = "orderby"
    val PRICE = "price"

    fun getBase_OPTION(): Map<String, String> {
        var BASE_OPTIONS = HashMap<String, String>()
        return BASE_OPTIONS
    }

    fun getProduct_OPTION(position: String): Map<String, String> {
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["category"] = position
        return BASE_OPTIONS
    }

    fun getCategory_OPTION(): Map<String, String> {
        //  var page=20
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        // BASE_OPTIONS["per_page"]=page.toString()
        return BASE_OPTIONS
    }

    fun getCategory_Items(page:Int,categoryId:String): Map<String, String>
    {
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["per_page"]=page.toString()
        BASE_OPTIONS["category"]=categoryId
        return BASE_OPTIONS
    }

   suspend fun getSearchOption(searchQuery:String,categoryId:String):Map<String, String>{
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["search"]=searchQuery
        BASE_OPTIONS["category"]=categoryId
        return BASE_OPTIONS
    }

    fun getCheapestOption(page:Int,categoryId:String):Map<String, String>{
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["orderby"]=PRICE
        BASE_OPTIONS["per_page"]=page.toString()
        BASE_OPTIONS["category"]=categoryId
        BASE_OPTIONS["order"]="asc"
        return BASE_OPTIONS
    }

    fun getExpensiveOption(page:Int,categoryId:String):Map<String, String>{
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["orderby"]=PRICE
        BASE_OPTIONS["per_page"]=page.toString()
        BASE_OPTIONS["category"]=categoryId
        BASE_OPTIONS["order"]="asc"
        return BASE_OPTIONS
    }

    fun getCustomer(email:String):Map<String, String>{
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["email"]=email
        return BASE_OPTIONS
    }

    /*
     productOptions.put("page", String.valueOf(page));
        productOptions.put("category", String.valueOf(categoryId));
     */
}





