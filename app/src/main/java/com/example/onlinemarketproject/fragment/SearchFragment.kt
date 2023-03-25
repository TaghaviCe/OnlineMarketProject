package com.example.onlinemarketproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.adapter.SearchRecyclerView
import com.example.onlinemarketproject.databinding.FragmentSearchBinding
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.viewmodels.HomeViewModel


class SearchFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private var productsList = listOf<productItemX>()
    private var productsList2 = listOf<productItemX>()
    private lateinit var binding: FragmentSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentSearchBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.homeViewModel= viewModel


        binding.productProductSearchList.adapter = SearchRecyclerView { id -> onProductItemClick(id) }


        setlistProduct()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                productsList= viewModel.getProductItem()!!
                productsList2 = productsList.filter { it.title.contains("$query",ignoreCase = true)}
                binding.productProductSearchList.adapter = SearchRecyclerView { id -> onProductItemClick(id) }
                viewModel.getSearchList(productsList2)
                attachSearchOnScrollListener( productsList2)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                productsList= viewModel.getProductItem()!!
                productsList2 = productsList.filter { it.title.contains("$newText",ignoreCase = true)}
                binding.productProductSearchList.adapter = SearchRecyclerView { id -> onProductItemClick(id) }
                viewModel.getSearchList(productsList2)
                attachSearchOnScrollListener( productsList2)
                return true
            }

        })

    }

    private fun onProductItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_searchFragment_to_productFragment, bundle)
    }


    private fun setlistProduct() {
        viewModel.getProductItem()
        attachProductListOnScrollListener()

    }

    private fun attachProductListOnScrollListener() {
        binding.productProductSearchList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getProductItem()

                }
            }
        })
    }


    private fun attachSearchOnScrollListener(productsList2: List<productItemX>) {
        binding.productProductSearchList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getSearchList(productsList2)

                }
            }
        })
    }




}