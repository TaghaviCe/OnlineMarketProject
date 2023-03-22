package com.example.onlinemarketproject.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.model.productItemX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


object myPreference {
//
//   lateinit var pref:SharedPreferences
//   lateinit var editor: SharedPreferences.Editor
//
//        fun init(context: Context) {
//            pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE)
//            editor = pref.edit()
//        }
//
//    fun addItem(productItemX: productItemX) {
//        val gson = Gson()
//        val orderList = if (getListItem().isNullOrEmpty()) {
//            mutableListOf()
//        } else {
//            getListItem() as MutableList<orderItem>
//        }
//        if (orderList.contains(
//                orderItem(
//                    productName = productItemX.name,
//                    product_id = productItemX.id,
//                    quantity = 1,
//                    price = productItemX.price,
//                    image = productItemX.images
//                )
//            )
//            || gson.toJson(orderList).contains(productItemX.name)
//        ) {
//          Log.i("yes","already exist!")
//        }else{
//            orderList.add(
//                orderItem(
//                    productName = productItemX.name,
//                    product_id = productItemX.id,
//                    quantity = 1,
//                    price = productItemX.price,
//                    image = productItemX.images
//                )
//            )
//            val listToJson=gson.toJson(orderList)
//            editor.putString("item",listToJson)
//            editor.apply()
//        }
//
//    }

//    fun getListItem():MutableList<orderItem>?{
//        val gson=Gson()
//        val jsonList=pref.getString("listProduct","")
//        val type:Type=object : TypeToken<List<orderItem>>(){}.type
//        return gson.fromJson(jsonList,type)
//    }
//
//    fun saveToSharedPreference(){
//        val gson=Gson()
//       // val listToJson=gson.toJson()
//    }

//    fun addIdItem(new:productItemX){
//        var productItems: List<productItemX>? = getCartProducts()
//        if (productItems == null) productItems = listOf()
//        productItems!!.toMutableList().add(new)
//        setCartProducts( productItems)
//        editor.apply()
//    }
//
//    fun setCartProducts( productItems: List<productItemX>?) {
//        val gson = Gson()
//        val jsonProducts = gson.toJson(productItems)
//
//        editor.putString(
//               "myProduct",
//                jsonProducts
//            )
//            .apply()
//    }
//    fun getCartProducts(): List<productItemX>? {
//        if (pref.contains("myProduct")) {
//            val jsonProducts: String? = pref.getString("myProduct", null)
//            val gson = Gson()
//            val productItems = gson.fromJson(jsonProducts,Array<productItemX>::class.java).asList()
//            return productItems
//        }
//        return null
//    }
//
//
//    fun getItem():Int{
//        var myId=pref.getInt("id",0)
//        return myId
//
//    }

}

/*
public class PreferenceUtil {
  private static SharedPreferences pref;

  public static void init(Context context) {
    pref = context.getSharedPreferences("mycardlist", Context.MODE_PRIVATE);
  }}
 */