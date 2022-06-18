package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.adapter.RecyclerViewCardAdapter
import com.example.onlinemarketproject.adapter.RecyclerViewProductAdapter
import com.example.onlinemarketproject.databinding.FragmentCartBinding
import com.example.onlinemarketproject.databinding.FragmentCategoryBinding
import com.example.onlinemarketproject.databinding.FragmentProductBinding
import com.example.onlinemarketproject.viewmodels.CartViewModel
import com.example.onlinemarketproject.viewmodels.ProductPageViewModel

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

        viewModel.getProdectListFromPreferenc()
        attachItemsOnScrollListener()

    }

    private fun attachItemsOnScrollListener() {
        binding.rvCartProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getProdectListFromPreferenc()

                }
            }
        })
    }




}