package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.adapter.RecyclerViewCardAdapter
import com.example.onlinemarketproject.databinding.FragmentCartBinding
import com.example.onlinemarketproject.model.LineItems
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.viewmodels.CartViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
var product_id=0
class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.cartViewModel=viewModel
        binding.rvCartProducts.adapter =RecyclerViewCardAdapter{ id -> onProductItemClick(id)}

        getListItem()?.let { viewModel.getListPref(it) }
        attachItemsOnScrollListener()
        binding.buttonCart.setOnClickListener {
            var sharedPreferencesForLogIn:SharedPreferences=requireActivity().getSharedPreferences("Logged_in",Context.MODE_PRIVATE)
            var flag=sharedPreferencesForLogIn.getInt("state",0)
            if(flag==0){
                Toast.makeText(
                    requireActivity(),
                    "you should login first...",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_cartFragment_to_loginUserFragment)
            }else if(flag==1){
                Toast.makeText(
                    requireActivity(),
                    "you should Login first...",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_cartFragment_to_loginUserFragment)
            }else if(flag==2){
                Toast.makeText(
                    requireActivity(),
                    "Your shopping cart has been registered. Going to payment page...",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

     fun onProductItemClick(id: Int) {
       product_id=id
        Log.i("idddd","id is ${product_id}")
        Toast.makeText(
            requireActivity(),
            "id is ${product_id}",
            Toast.LENGTH_SHORT
        ).show()
        deleteItemFromCart(product_id)
        Toast.makeText(
            requireActivity(),
            "deleted from your shopping cart",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun deleteItemFromCart(listItems: Int) {
        val jsonList= getListItem()?.toMutableList()
        val iterator=jsonList?.iterator()
        var a=0
        for(p in jsonList!!){
          if (listItems ==p.id){
             a=1
             p.quantity=0
          }
        }
        while(iterator!!.hasNext()){
            val item=iterator.next()
            if(item.quantity==0){
               iterator.remove()

            }
        }

//        Toast.makeText(
//            requireActivity(),
//            "${jsonList}",
//            Toast.LENGTH_SHORT
//        ).show()

        saveToSharedPreference(jsonList)
        binding.cartViewModel=viewModel
        getListItem()?.let { viewModel.getListPref(it) }
        attachItemsOnScrollListener()

    }



    fun getListItem():List<LineItems>?{
        var sharedPreferences:SharedPreferences=requireActivity().getSharedPreferences("cartItemList",Context.MODE_PRIVATE)
        val gson=Gson()
        val jsonList= sharedPreferences.getString("listProduct","")
        val type: Type =object : TypeToken<List<LineItems>>(){}.type
        return gson.fromJson(jsonList,type)
    }
    fun saveToSharedPreference(newList:List<LineItems>){
        var sharedPreferences:SharedPreferences=requireActivity().getSharedPreferences("cartItemList",Context.MODE_PRIVATE)
        var  editor = sharedPreferences.edit()
        val gson=Gson()
        val listToJson=gson.toJson(newList)
        editor.putString("listProduct",listToJson)
        editor.apply()
    }

    private fun attachItemsOnScrollListener() {
        binding.rvCartProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    getListItem()?.let { viewModel.getListPref(it) }

                }
            }
        })
    }







}