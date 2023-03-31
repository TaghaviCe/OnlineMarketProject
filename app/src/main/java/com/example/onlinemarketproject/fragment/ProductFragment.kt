package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.onlinemarketproject.databinding.FragmentProductBinding
import com.example.onlinemarketproject.model.LineItems
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.viewmodels.ProductPageViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ProductFragment : Fragment() {

   private val pageViewModel: ProductPageViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.productViewModel = pageViewModel
        var id = requireArguments().getInt(product, 0)
        pageViewModel.getProductWithId(id)

        binding.button4.setOnClickListener {
               var newProduct= pageViewModel.getProductWithId(id)
            if (newProduct!=null) {
                addItem(newProduct)
            }

    }


        }


    fun addItem(productItemX: productItemX) {
        var sharedPreferences:SharedPreferences=requireActivity().getSharedPreferences("cartItemList",Context.MODE_PRIVATE)
        var editor=sharedPreferences.edit()
        val gson = Gson()
        val orderList = if (getListItem().isNullOrEmpty()) {
            mutableListOf()
        } else {
            getListItem() as MutableList<LineItems>
        }
        if (orderList.contains(
                LineItems(
                    title = productItemX.title,
                    image = productItemX.image,
                    pricePerItem = productItemX.price.toDouble(),
                    quantity = productItemX.rating.rate.toInt(),
                    price = productItemX.price.toString(),
                    id = productItemX.id.toInt()

                )
            )
            || gson.toJson(orderList).contains(productItemX.title)
        ) {

            Toast.makeText(context,"این آیتم قبلا اضافه شده است.",Toast.LENGTH_SHORT).show()

        }else{
            orderList.add(
                LineItems(
                    title = productItemX.title,
                    image = productItemX.image,
                    pricePerItem = productItemX.price.toDouble(),
                    quantity = productItemX.rating.rate.toInt(),
                    price = productItemX.price.toString(),
                    id = productItemX.id.toInt()

                )
            )
            val listToJson=gson.toJson(orderList)
           editor.putString("listProduct",listToJson)
           editor.apply()
        }

    }

    fun getListItem():List<LineItems>?{
        var sharedPreferences:SharedPreferences=requireActivity().getSharedPreferences("cartItemList",Context.MODE_PRIVATE)
        val gson=Gson()
        val jsonList= sharedPreferences.getString("listProduct","")
        val type: Type =object : TypeToken<List<LineItems>>(){}.type
        return gson.fromJson(jsonList,type)
    }





    }



