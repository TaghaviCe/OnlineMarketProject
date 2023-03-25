package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
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
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.viewmodels.CartViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()
    private lateinit var binding: FragmentCartBinding
    //lateinit var pref : SharedPreferences

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
        binding.rvCartProducts.adapter =RecyclerViewCardAdapter()

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