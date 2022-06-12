package com.example.onlinemarketproject.network

class ApiParameter {
    val BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/"
    val CONSUMER_KEY = "ck_29aec1232103e448630099766d5c854cd455457a"
    val CONSUMER_SECRET = "cs_697a74a236b94220fa1345271bc0dfe6acdd5c81"

    val POPULAR = "popularity"
    val RECENT = "date"
    val TOP = "rating"
    val ORDERBY = "orderby"
    val PRICE = "price"

    fun getBase_OPTION(): Map<String, String> {
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS["consumer_key"] = CONSUMER_KEY
        BASE_OPTIONS["consumer_secret"] = CONSUMER_SECRET
        return BASE_OPTIONS
    }

    fun getProduct_OPTION(position: String): Map<String, String> {
        var BASE_OPTIONS = HashMap<String, String>()
        BASE_OPTIONS.putAll(getBase_OPTION())
        BASE_OPTIONS["orderby"] = position
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

    /*
     productOptions.put("page", String.valueOf(page));
        productOptions.put("category", String.valueOf(categoryId));
     */
}





